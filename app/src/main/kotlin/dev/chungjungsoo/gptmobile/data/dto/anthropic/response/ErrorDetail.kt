package dev.chungjungsoo.gptmobile.data.dto.anthropic.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents the details of an error.
 *
 * @property type The type of the error.
 * @property message The error message.
 */
@Serializable
data class ErrorDetail(

    @SerialName("type")
    val type: String,

    @SerialName("message")
    val message: String
)
