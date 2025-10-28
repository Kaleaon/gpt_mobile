package dev.chungjungsoo.gptmobile.data.dto.anthropic.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents a content delta response chunk.
 *
 * @property index The index of the content block.
 * @property delta The content block delta.
 */
@Serializable
@SerialName("content_block_delta")
data class ContentDeltaResponseChunk(

    @SerialName("index")
    val index: Int,

    @SerialName("delta")
    val delta: ContentBlock
) : MessageResponseChunk()
