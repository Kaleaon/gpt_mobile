package dev.chungjungsoo.gptmobile.data.dto.anthropic.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents an image content in a message.
 *
 * @property source The source of the image.
 */
@Serializable
@SerialName("image")
data class ImageContent(

    @SerialName("source")
    val source: ImageSource
) : MessageContent()
