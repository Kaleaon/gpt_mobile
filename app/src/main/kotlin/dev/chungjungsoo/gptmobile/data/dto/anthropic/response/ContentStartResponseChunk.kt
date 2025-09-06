package dev.chungjungsoo.gptmobile.data.dto.anthropic.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents a content start response chunk.
 *
 * @property index The index of the content block.
 * @property contentBlock The content block.
 */
@Serializable
@SerialName("content_block_start")
data class ContentStartResponseChunk(

    @SerialName("index")
    val index: Int,

    @SerialName("content_block")
    val contentBlock: ContentBlock
) : MessageResponseChunk()
