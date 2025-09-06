package dev.chungjungsoo.gptmobile.data.dto.anthropic.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents a message start response chunk.
 *
 * @property message The message response.
 */
@Serializable
@SerialName("message_start")
data class MessageStartResponseChunk(

    @SerialName("message")
    val message: MessageResponse
) : MessageResponseChunk()
