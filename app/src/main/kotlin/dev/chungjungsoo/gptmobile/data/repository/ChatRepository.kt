package dev.chungjungsoo.gptmobile.data.repository

import dev.chungjungsoo.gptmobile.data.database.entity.ChatRoom
import dev.chungjungsoo.gptmobile.data.database.entity.Message
import dev.chungjungsoo.gptmobile.data.dto.ApiState
import kotlinx.coroutines.flow.Flow

/**
 * An interface for the chat repository.
 */
interface ChatRepository {

    /**
     * Completes a chat with the OpenAI API.
     *
     * @param question The user's question.
     * @param history The chat history.
     * @return A flow of API states.
     */
    suspend fun completeOpenAIChat(question: Message, history: List<Message>): Flow<ApiState>
    /**
     * Completes a chat with the Anthropic API.
     *
     * @param question The user's question.
     * @param history The chat history.
     * @return A flow of API states.
     */
    suspend fun completeAnthropicChat(question: Message, history: List<Message>): Flow<ApiState>
    /**
     * Completes a chat with the Google API.
     *
     * @param question The user's question.
     * @param history The chat history.
     * @return A flow of API states.
     */
    suspend fun completeGoogleChat(question: Message, history: List<Message>): Flow<ApiState>
    /**
     * Completes a chat with the Groq API.
     *
     * @param question The user's question.
     * @param history The chat history.
     * @return A flow of API states.
     */
    suspend fun completeGroqChat(question: Message, history: List<Message>): Flow<ApiState>
    /**
     * Completes a chat with the Ollama API.
     *
     * @param question The user's question.
     * @param history The chat history.
     * @return A flow of API states.
     */
    suspend fun completeOllamaChat(question: Message, history: List<Message>): Flow<ApiState>
    /**
     * Fetches the list of chat rooms.
     *
     * @return A list of chat rooms.
     */
    suspend fun fetchChatList(): List<ChatRoom>
    /**
     * Fetches the messages for a chat room.
     *
     * @param chatId The ID of the chat room.
     * @return A list of messages.
     */
    suspend fun fetchMessages(chatId: Int): List<Message>
    /**
     * Generates a default chat title.
     *
     * @param messages The list of messages in the chat.
     * @return The default chat title.
     */
    fun generateDefaultChatTitle(messages: List<Message>): String?
    /**
     * Updates the title of a chat room.
     *
     * @param chatRoom The chat room to update.
     * @param title The new title.
     */
    suspend fun updateChatTitle(chatRoom: ChatRoom, title: String)
    /**
     * Saves a chat.
     *
     * @param chatRoom The chat room to save.
     * @param messages The list of messages in the chat.
     * @return The saved chat room.
     */
    suspend fun saveChat(chatRoom: ChatRoom, messages: List<Message>): ChatRoom
    /**
     * Deletes a list of chat rooms.
     *
     * @param chatRooms The list of chat rooms to delete.
     */
    suspend fun deleteChats(chatRooms: List<ChatRoom>)
}
