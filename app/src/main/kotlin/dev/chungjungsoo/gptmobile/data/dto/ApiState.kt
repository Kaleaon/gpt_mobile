package dev.chungjungsoo.gptmobile.data.dto

/**
 * A sealed class that represents the state of an API call.
 */
sealed class ApiState {
    /**
     * The loading state.
     */
    data object Loading : ApiState()
    /**
     * The success state.
     *
     * @property textChunk The text chunk received from the API.
     */
    data class Success(val textChunk: String) : ApiState()
    /**
     * The error state.
     *
     * @property message The error message.
     */
    data class Error(val message: String) : ApiState()
    /**
     * The done state.
     */
    data object Done : ApiState()
}
