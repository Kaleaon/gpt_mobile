package dev.chungjungsoo.gptmobile.presentation.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.chungjungsoo.gptmobile.data.database.entity.ChatRoom
import dev.chungjungsoo.gptmobile.data.dto.Platform
import dev.chungjungsoo.gptmobile.data.repository.ChatRepository
import dev.chungjungsoo.gptmobile.data.repository.SettingRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * The view model for the home screen.
 *
 * @property chatRepository The repository for chat-related operations.
 * @property settingRepository The repository for settings-related operations.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val chatRepository: ChatRepository,
    private val settingRepository: SettingRepository
) : ViewModel() {

    /**
     * The state of the chat list.
     *
     * @property chats The list of chat rooms.
     * @property isSelectionMode Whether the selection mode is enabled.
     * @property selected The list of selected chat rooms.
     */
    data class ChatListState(
        val chats: List<ChatRoom> = listOf(),
        val isSelectionMode: Boolean = false,
        val selected: List<Boolean> = listOf()
    )

    private val _chatListState = MutableStateFlow(ChatListState())
    /**
     * The state flow for the chat list.
     */
    val chatListState: StateFlow<ChatListState> = _chatListState.asStateFlow()

    private val _platformState = MutableStateFlow(listOf<Platform>())
    /**
     * The state flow for the platform list.
     */
    val platformState: StateFlow<List<Platform>> = _platformState.asStateFlow()

    private val _showSelectModelDialog = MutableStateFlow(false)
    /**
     * The state flow for the select model dialog.
     */
    val showSelectModelDialog: StateFlow<Boolean> = _showSelectModelDialog.asStateFlow()

    private val _showDeleteWarningDialog = MutableStateFlow(false)
    /**
     * The state flow for the delete warning dialog.
     */
    val showDeleteWarningDialog: StateFlow<Boolean> = _showDeleteWarningDialog.asStateFlow()

    /**
     * Updates the checked state of a platform.
     *
     * @param platform The platform to update.
     */
    fun updateCheckedState(platform: Platform) {
        val index = _platformState.value.indexOf(platform)

        if (index >= 0) {
            _platformState.update {
                it.mapIndexed { i, p ->
                    if (index == i) {
                        p.copy(selected = p.selected.not())
                    } else {
                        p
                    }
                }
            }
        }
    }

    /**
     * Opens the delete warning dialog.
     */
    fun openDeleteWarningDialog() {
        closeSelectModelDialog()
        _showDeleteWarningDialog.update { true }
    }

    /**
     * Closes the delete warning dialog.
     */
    fun closeDeleteWarningDialog() {
        _showDeleteWarningDialog.update { false }
    }

    /**
     * Opens the select model dialog.
     */
    fun openSelectModelDialog() {
        _showSelectModelDialog.update { true }
        disableSelectionMode()
    }

    /**
     * Closes the select model dialog.
     */
    fun closeSelectModelDialog() {
        _showSelectModelDialog.update { false }
    }

    /**
     * Deletes the selected chats.
     */
    fun deleteSelectedChats() {
        viewModelScope.launch {
            val selectedChats = _chatListState.value.chats.filterIndexed { index, _ ->
                _chatListState.value.selected[index]
            }

            chatRepository.deleteChats(selectedChats)
            _chatListState.update { it.copy(chats = chatRepository.fetchChatList()) }
            disableSelectionMode()
        }
    }

    /**
     * Disables the selection mode.
     */
    fun disableSelectionMode() {
        _chatListState.update {
            it.copy(
                selected = List(it.chats.size) { false },
                isSelectionMode = false
            )
        }
    }

    /**
     * Enables the selection mode.
     */
    fun enableSelectionMode() {
        _chatListState.update { it.copy(isSelectionMode = true) }
    }

    /**
     * Fetches the list of chats.
     */
    fun fetchChats() {
        viewModelScope.launch {
            val chats = chatRepository.fetchChatList()

            _chatListState.update {
                it.copy(
                    chats = chats,
                    selected = List(chats.size) { false },
                    isSelectionMode = false
                )
            }

            Log.d("chats", "${_chatListState.value.chats}")
        }
    }

    /**
     * Fetches the status of the platforms.
     */
    fun fetchPlatformStatus() {
        viewModelScope.launch {
            val platforms = settingRepository.fetchPlatforms()
            _platformState.update { platforms }
        }
    }

    /**
     * Selects a chat.
     *
     * @param chatRoomIdx The index of the chat to select.
     */
    fun selectChat(chatRoomIdx: Int) {
        if (chatRoomIdx < 0 || chatRoomIdx > _chatListState.value.chats.size) return

        _chatListState.update {
            it.copy(
                selected = it.selected.mapIndexed { index, b ->
                    if (index == chatRoomIdx) {
                        !b
                    } else {
                        b
                    }
                }
            )
        }

        if (_chatListState.value.selected.count { it } == 0) {
            disableSelectionMode()
        }
    }
}
