package dev.chungjungsoo.gptmobile.data.network

import dev.chungjungsoo.gptmobile.data.dto.anthropic.request.MessageRequest
import dev.chungjungsoo.gptmobile.data.dto.anthropic.response.MessageResponseChunk
import kotlinx.coroutines.flow.Flow

/**
 * An interface for the Anthropic API.
 */
interface AnthropicAPI {
    /**
     * Sets the API token.
     *
     * @param token The API token.
     */
    fun setToken(token: String?)
    /**
     * Sets the API URL.
     *
     * @param url The API URL.
     */
    fun setAPIUrl(url: String)
    /**
     * Streams a chat message.
     *
     * @param messageRequest The message request.
     * @return A flow of message response chunks.
     */
    fun streamChatMessage(messageRequest: MessageRequest): Flow<MessageResponseChunk>
}
