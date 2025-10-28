package dev.chungjungsoo.gptmobile.data.dto.anthropic.request

import dev.chungjungsoo.gptmobile.data.dto.anthropic.common.MessageContent
import dev.chungjungsoo.gptmobile.data.dto.anthropic.common.MessageRole
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents an input message.
 *
 * @property role The role of the message.
 * @property content The content of the message.
 */
@Serializable
data class InputMessage(
    @SerialName("role")
    val role: MessageRole,

    @SerialName("content")
    val content: List<MessageContent>
)
