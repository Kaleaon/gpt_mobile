package dev.chungjungsoo.gptmobile.data.dto.anthropic.request

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents a message request.
 *
 * When certain value is used in the future, use @EncodeDefault or remove default values
 *
 * @property model The model to use for the request.
 * @property messages The list of messages to send.
 * @property maxTokens The maximum number of tokens to generate.
 * @property metadata The metadata for the request.
 * @property stopSequences The list of stop sequences.
 * @property stream Whether to stream the response.
 * @property systemPrompt The system prompt.
 * @property temperature The temperature for the request.
 * @property topK The top-k value for the request.
 * @property topP The top-p value for the request.
 */
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class MessageRequest(
    @SerialName("model")
    val model: String,

    @SerialName("messages")
    val messages: List<InputMessage>,

    @SerialName("max_tokens")
    val maxTokens: Int,

    @SerialName("metadata")
    @EncodeDefault(EncodeDefault.Mode.NEVER)
    val metadata: RequestMetadata? = null,

    @SerialName("stop_sequences")
    @EncodeDefault(EncodeDefault.Mode.NEVER)
    val stopSequences: List<String>? = null,

    @SerialName("stream")
    @EncodeDefault(EncodeDefault.Mode.NEVER)
    val stream: Boolean = false,

    @SerialName("system")
    @EncodeDefault(EncodeDefault.Mode.NEVER)
    val systemPrompt: String? = null,

    @SerialName("temperature")
    @EncodeDefault(EncodeDefault.Mode.NEVER)
    val temperature: Float? = null,

    @SerialName("top_k")
    @EncodeDefault(EncodeDefault.Mode.NEVER)
    val topK: Int? = null,

    @SerialName("top_p")
    @EncodeDefault(EncodeDefault.Mode.NEVER)
    val topP: Float? = null
)
