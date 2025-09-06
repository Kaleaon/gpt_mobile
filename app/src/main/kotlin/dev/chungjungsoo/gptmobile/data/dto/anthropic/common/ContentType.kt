package dev.chungjungsoo.gptmobile.data.dto.anthropic.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An enum that represents the type of content in a message.
 */
@Serializable
enum class ContentType {

    /**
     * A text content.
     */
    @SerialName("text")
    TEXT,

    /**
     * An image content.
     */
    @SerialName("image")
    IMAGE
}
