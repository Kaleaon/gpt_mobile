package dev.chungjungsoo.gptmobile.data.dto.anthropic.response

import dev.chungjungsoo.gptmobile.data.dto.anthropic.common.MessageRole
import dev.chungjungsoo.gptmobile.data.dto.anthropic.common.TextContent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents a message response.
 *
 * @property id The ID of the message.
 * @property type The type of the message.
 * @property role The role of the message.
 * @property content The content of the message.
 * @property model The model used for the response.
 * @property stopReason The reason why the response was stopped.
 * @property stopSequence The stop sequence.
 * @property usage The usage of the response.
 */
@Serializable
data class MessageResponse(
    @SerialName("id")
    val id: String,

    @SerialName("type")
    val type: String = "message",

    @SerialName("role")
    val role: MessageRole = MessageRole.ASSISTANT,

    @SerialName("content")
    val content: List<TextContent>,

    @SerialName("model")
    val model: String,

    @SerialName("stop_reason")
    val stopReason: StopReason? = null,

    @SerialName("stop_sequence")
    val stopSequence: String? = null,

    @SerialName("usage")
    val usage: Usage
)
