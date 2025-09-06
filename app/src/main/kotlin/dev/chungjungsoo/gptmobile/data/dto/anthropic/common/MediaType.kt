package dev.chungjungsoo.gptmobile.data.dto.anthropic.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An enum that represents the media type of an image.
 */
@Serializable
enum class MediaType {

    /**
     * A JPEG image.
     */
    @SerialName("image/jpeg")
    JPEG,

    /**
     * A PNG image.
     */
    @SerialName("image/png")
    PNG,

    /**
     * A GIF image.
     */
    @SerialName("image/gif")
    GIF,

    /**
     * A WebP image.
     */
    @SerialName("image/webp")
    WEBP
}
