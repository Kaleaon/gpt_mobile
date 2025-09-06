package dev.chungjungsoo.gptmobile.data.dto.anthropic.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An enum that represents the type of a content block.
 */
@Serializable
enum class ContentBlockType {

    /**
     * A text content block.
     */
    @SerialName("text")
    TEXT,

    /**
     * A text delta content block.
     */
    @SerialName("text_delta")
    DELTA
}
