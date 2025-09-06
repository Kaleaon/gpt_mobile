package dev.chungjungsoo.gptmobile.data.dto.anthropic.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents a message delta response chunk.
 *
 * @property delta The stop reason delta.
 * @property usage The usage delta.
 */
@Serializable
@SerialName("message_delta")
data class MessageDeltaResponseChunk(

    @SerialName("delta")
    val delta: StopReasonDelta,

    @SerialName("usage")
    val usage: UsageDelta
) : MessageResponseChunk()
