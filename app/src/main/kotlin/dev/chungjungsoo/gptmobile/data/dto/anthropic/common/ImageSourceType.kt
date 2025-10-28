package dev.chungjungsoo.gptmobile.data.dto.anthropic.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An enum that represents the type of an image source.
 */
@Serializable
enum class ImageSourceType {

    /**
     * A base64-encoded image.
     */
    @SerialName("base64")
    BASE64
}
