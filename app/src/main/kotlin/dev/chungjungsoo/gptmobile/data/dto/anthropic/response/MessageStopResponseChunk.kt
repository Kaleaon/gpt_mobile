package dev.chungjungsoo.gptmobile.data.dto.anthropic.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data object that represents a message stop response chunk.
 */
@Serializable
@SerialName("message_stop")
data object MessageStopResponseChunk : MessageResponseChunk()
