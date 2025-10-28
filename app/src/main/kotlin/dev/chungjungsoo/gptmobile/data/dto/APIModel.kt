package dev.chungjungsoo.gptmobile.data.dto

/**
 * A data class that represents an API model.
 *
 * @property name The name of the model.
 * @property description A description of the model.
 * @property aliasValue The alias value of the model.
 */
data class APIModel(
    val name: String,
    val description: String,
    val aliasValue: String
)
