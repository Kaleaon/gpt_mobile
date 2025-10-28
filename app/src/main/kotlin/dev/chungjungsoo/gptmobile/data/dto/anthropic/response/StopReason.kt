package dev.chungjungsoo.gptmobile.data.dto.anthropic.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An enum that represents the reason why a response was stopped.
 */
@Serializable
enum class StopReason {

    /**
     * The response was stopped because the turn ended.
     */
    @SerialName("end_turn")
    END_TURN,

    /**
     * The response was stopped because the maximum number of tokens was reached.
     */
    @SerialName("max_tokens")
    MAX_TOKENS,

    /**
     * The response was stopped because a stop sequence was reached.
     */
    @SerialName("stop_sequence")
    STOP_SEQUENCE,

    /**
     * The response was stopped because a tool was used.
     */
    @SerialName("tool_use")
    TOOL_USE
}
