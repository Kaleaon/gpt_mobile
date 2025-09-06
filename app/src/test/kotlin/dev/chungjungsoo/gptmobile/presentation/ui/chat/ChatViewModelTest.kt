package dev.chungjungsoo.gptmobile.presentation.ui.chat

import androidx.lifecycle.SavedStateHandle
import dev.chungjungsoo.gptmobile.data.database.entity.Message
import dev.chungjungsoo.gptmobile.data.model.ApiType
import dev.chungjungsoo.gptmobile.data.repository.ChatRepository
import dev.chungjungsoo.gptmobile.data.repository.SettingRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.test.*
import org.junit.Assert.assertEquals
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
class ChatViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: ChatViewModel
    private val chatRepository: ChatRepository = mockk(relaxed = true)
    private val settingRepository: SettingRepository = mockk(relaxed = true)
    private val savedStateHandle: SavedStateHandle = SavedStateHandle(
        mapOf(
            "chatRoomId" to 1,
            "enabledPlatforms" to "OPENAI"
        )
    )

    private val initialMessages = listOf(
        Message(id = 1, chatId = 1, content = "Hello", platformType = null, createdAt = 1000),
        Message(id = 2, chatId = 1, content = "Hi there", platformType = ApiType.OPENAI, createdAt = 1001),
        Message(id = 3, chatId = 1, content = "How are you?", platformType = null, createdAt = 1002),
        Message(id = 4, chatId = 1, content = "I am fine", platformType = ApiType.OPENAI, createdAt = 1003),
        // This message has a higher ID but an equal timestamp to the message being edited (id=3).
        // The buggy filter `message.id < q.id && message.createdAt < q.createdAt` will not remove this message.
        Message(id = 5, chatId = 1, content = "This should be removed", platformType = null, createdAt = 1002),
        Message(id = 6, chatId = 1, content = "This also", platformType = ApiType.OPENAI, createdAt = 1004)
    )

    @Before
    fun setUp() {
        coEvery { chatRepository.fetchMessages(1) } returns initialMessages
        coEvery { chatRepository.completeOpenAIChat(any(), any()) } returns emptyFlow()

        viewModel = ChatViewModel(savedStateHandle, chatRepository, settingRepository)
    }

    @Test
    fun `editQuestion should remove subsequent messages regardless of createdAt timestamp`() = runTest {
        // The ViewModel's init block launches a coroutine to fetch messages.
        // With UnconfinedTestDispatcher, this should run eagerly.
        // Let's verify the initial state.
        assertEquals(initialMessages, viewModel.messages.value)

        // When
        val messageToEdit = initialMessages[2] // Message with id = 3
        viewModel.editQuestion(messageToEdit.copy(content = "A new question"))

        // Then
        val expectedMessages = initialMessages.subList(0, 2)
        assertEquals(expectedMessages, viewModel.messages.value)
    }
}
