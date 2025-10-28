package dev.chungjungsoo.gptmobile.data.datastore

import dev.chungjungsoo.gptmobile.data.model.ApiType
import dev.chungjungsoo.gptmobile.data.model.DynamicTheme
import dev.chungjungsoo.gptmobile.data.model.ThemeMode

/**
 * An interface for the setting data source.
 */
interface SettingDataSource {
    /**
     * Updates the dynamic theme.
     *
     * @param theme The new dynamic theme.
     */
    suspend fun updateDynamicTheme(theme: DynamicTheme)
    /**
     * Updates the theme mode.
     *
     * @param themeMode The new theme mode.
     */
    suspend fun updateThemeMode(themeMode: ThemeMode)
    /**
     * Updates the status of an API type.
     *
     * @param apiType The type of the API.
     * @param status The new status.
     */
    suspend fun updateStatus(apiType: ApiType, status: Boolean)
    /**
     * Updates the API URL for an API type.
     *
     * @param apiType The type of the API.
     * @param url The new URL.
     */
    suspend fun updateAPIUrl(apiType: ApiType, url: String)
    /**
     * Updates the token for an API type.
     *
     * @param apiType The type of the API.
     * @param token The new token.
     */
    suspend fun updateToken(apiType: ApiType, token: String)
    /**
     * Updates the model for an API type.
     *
     * @param apiType The type of the API.
     * @param model The new model.
     */
    suspend fun updateModel(apiType: ApiType, model: String)
    /**
     * Updates the temperature for an API type.
     *
     * @param apiType The type of the API.
     * @param temperature The new temperature.
     */
    suspend fun updateTemperature(apiType: ApiType, temperature: Float)
    /**
     * Updates the top-p value for an API type.
     *
     * @param apiType The type of the API.
     * @param topP The new top-p value.
     */
    suspend fun updateTopP(apiType: ApiType, topP: Float)
    /**
     * Updates the system prompt for an API type.
     *
     * @param apiType The type of the API.
     * @param prompt The new system prompt.
     */
    suspend fun updateSystemPrompt(apiType: ApiType, prompt: String)
    /**
     * Returns the dynamic theme.
     *
     * @return The dynamic theme.
     */
    suspend fun getDynamicTheme(): DynamicTheme?
    /**
     * Returns the theme mode.
     *
     * @return The theme mode.
     */
    suspend fun getThemeMode(): ThemeMode?
    /**
     * Returns the status of an API type.
     *
     * @param apiType The type of the API.
     * @return The status of the API type.
     */
    suspend fun getStatus(apiType: ApiType): Boolean?
    /**
     * Returns the API URL for an API type.
     *
     * @param apiType The type of the API.
     * @return The API URL for the API type.
     */
    suspend fun getAPIUrl(apiType: ApiType): String?
    /**
     * Returns the token for an API type.
     *
     * @param apiType The type of the API.
     * @return The token for the API type.
     */
    suspend fun getToken(apiType: ApiType): String?
    /**
     * Returns the model for an API type.
     *
     * @param apiType The type of the API.
     * @return The model for the API type.
     */
    suspend fun getModel(apiType: ApiType): String?
    /**
     * Returns the temperature for an API type.
     *
     * @param apiType The type of the API.
     * @return The temperature for the API type.
     */
    suspend fun getTemperature(apiType: ApiType): Float?
    /**
     * Returns the top-p value for an API type.
     *
     * @param apiType The type of the API.
     * @return The top-p value for the API type.
     */
    suspend fun getTopP(apiType: ApiType): Float?
    /**
     * Returns the system prompt for an API type.
     *
     * @param apiType The type of the API.
     * @return The system prompt for the API type.
     */
    suspend fun getSystemPrompt(apiType: ApiType): String?
}
