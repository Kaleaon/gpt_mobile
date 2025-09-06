package dev.chungjungsoo.gptmobile.presentation.ui.home

import dev.chungjungsoo.gptmobile.data.database.entity.ChatRoom
import dev.chungjungsoo.gptmobile.data.repository.ChatRepository
import dev.chungjungsoo.gptmobile.data.repository.SettingRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@ExperimentalCoroutinesApi
class MainCoroutineRule(
    val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()
) : TestWatcher() {
    override fun starting(description: Description) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }
}

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: HomeViewModel
    private val chatRepository: ChatRepository = mockk(relaxed = true)
    private val settingRepository: SettingRepository = mockk(relaxed = true)

    @Before
    fun setUp() {
        viewModel = HomeViewModel(chatRepository, settingRepository)
    }

    @Test
    fun `selecting last item should disable selection mode`() = runTest {
        // Given
        val chats = listOf(
            ChatRoom(id = 1, title = "Chat 1"),
            ChatRoom(id = 2, title = "Chat 2")
        )
        coEvery { chatRepository.fetchChatList() } returns chats
        viewModel.fetchChats()

        // With UnconfinedTestDispatcher, the coroutine in fetchChats should run eagerly.
        // Let's verify the initial state.
        assertTrue(viewModel.chatListState.value.chats.size == 2)

        viewModel.enableSelectionMode()
        viewModel.selectChat(0) // Select first chat

        assertTrue(viewModel.chatListState.value.isSelectionMode)
        assertTrue(viewModel.chatListState.value.selected[0])

        // When
        viewModel.selectChat(0) // Deselect first chat

        // Then
        assertFalse(viewModel.chatListState.value.isSelectionMode)
    }
}
