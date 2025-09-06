package dev.chungjungsoo.gptmobile.data.dto.anthropic.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class that represents the metadata for a request.
 *
 * @property userId The ID of the user.
 */
@Serializable
data class RequestMetadata(
    @SerialName("user_id")
    val userId: String? = null
)
