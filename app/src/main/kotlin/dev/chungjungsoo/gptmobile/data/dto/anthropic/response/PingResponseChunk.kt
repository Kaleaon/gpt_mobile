package dev.chungjungsoo.gptmobile.data.dto.anthropic.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data object that represents a ping response chunk.
 */
@Serializable
@SerialName("ping")
data object PingResponseChunk : MessageResponseChunk()
