package dev.chungjungsoo.gptmobile.data.dto.anthropic.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An enum that represents the role of a message.
 */
@Serializable
enum class MessageRole {

    /**
     * A user message.
     */
    @SerialName("user")
    USER,

    /**
     * An assistant message.
     */
    @SerialName("assistant")
    ASSISTANT
}
