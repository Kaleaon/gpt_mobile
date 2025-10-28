package dev.chungjungsoo.gptmobile.data.dto.anthropic.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents the usage delta of a response.
 *
 * @property outputTokens The number of output tokens.
 */
@Serializable
data class UsageDelta(

    @SerialName("output_tokens")
    val outputTokens: Int
)
