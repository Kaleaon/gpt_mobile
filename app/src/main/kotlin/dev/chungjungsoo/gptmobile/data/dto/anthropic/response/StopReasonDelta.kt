package dev.chungjungsoo.gptmobile.data.dto.anthropic.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents a stop reason delta.
 *
 * @property stopReason The reason why the response was stopped.
 * @property stopSequence The stop sequence.
 */
@Serializable
data class StopReasonDelta(

    @SerialName("stop_reason")
    val stopReason: StopReason,

    @SerialName("stop_sequence")
    val stopSequence: String? = null
)
