package dev.chungjungsoo.gptmobile.data.dto.anthropic.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents the usage of a response.
 *
 * @property inputTokens The number of input tokens.
 * @property cacheCreationInputTokens The number of input tokens used for cache creation.
 * @property cacheReadInputTokens The number of input tokens read from the cache.
 * @property outputTokens The number of output tokens.
 */
@Serializable
data class Usage(

    @SerialName("input_tokens")
    val inputTokens: Int,

    @SerialName("cache_creation_input_tokens")
    val cacheCreationInputTokens: Int? = null,

    @SerialName("cache_read_input_tokens")
    val cacheReadInputTokens: Int? = null,

    @SerialName("output_tokens")
    val outputTokens: Int
)
