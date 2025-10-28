package dev.chungjungsoo.gptmobile.data.dto.anthropic.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents the source of an image.
 *
 * @property type The type of the image source.
 * @property mediaType The media type of the image.
 * @property data The image data.
 */
@Serializable
data class ImageSource(
    @SerialName("type")
    val type: ImageSourceType,

    @SerialName("media_type")
    val mediaType: MediaType,

    @SerialName("data")
    val data: String
)
