package dev.chungjungsoo.gptmobile.data.dto

import dev.chungjungsoo.gptmobile.data.ModelConstants.getDefaultAPIUrl
import dev.chungjungsoo.gptmobile.data.model.ApiType

/**
 * A data class that represents a platform.
 *
 * @property name The name of the platform.
 * @property selected Whether the platform is selected.
 * @property enabled Whether the platform is enabled.
 * @property apiUrl The API URL for the platform.
 * @property token The API token for the platform.
 * @property model The model to use for the platform.
 * @property temperature The temperature to use for the platform.
 * @property topP The top-p value to use for the platform.
 * @property systemPrompt The system prompt to use for the platform.
 */
data class Platform(
    val name: ApiType,
    val selected: Boolean = false,
    val enabled: Boolean = false,
    val apiUrl: String = getDefaultAPIUrl(name),
    val token: String? = null,
    val model: String? = null,
    val temperature: Float? = null,
    val topP: Float? = null,
    val systemPrompt: String? = null
)
