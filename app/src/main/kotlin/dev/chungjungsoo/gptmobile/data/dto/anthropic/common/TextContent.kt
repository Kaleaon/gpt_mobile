package dev.chungjungsoo.gptmobile.data.dto.anthropic.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents a text content in a message.
 *
 * @property text The text content.
 */
@Serializable
@SerialName("text")
data class TextContent(

    @SerialName("text")
    val text: String
) : MessageContent()
