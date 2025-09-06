package dev.chungjungsoo.gptmobile.presentation.ui.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.chungjungsoo.gptmobile.data.dto.Platform
import dev.chungjungsoo.gptmobile.data.model.ApiType
import dev.chungjungsoo.gptmobile.data.repository.SettingRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * The view model for the settings screen.
 *
 * @property settingRepository The repository for settings-related operations.
 */
@HiltViewModel
class SettingViewModel @Inject constructor(
    private val settingRepository: SettingRepository
) : ViewModel() {

    private val _platformState = MutableStateFlow(listOf<Platform>())
    /**
     * The state flow for the platform list.
     */
    val platformState: StateFlow<List<Platform>> = _platformState.asStateFlow()

    private val _dialogState = MutableStateFlow(DialogState())
    /**
     * The state flow for the dialog state.
     */
    val dialogState: StateFlow<DialogState> = _dialogState.asStateFlow()

    init {
        fetchPlatformStatus()
    }

    /**
     * Toggles the API for a platform.
     *
     * @param apiType The type of the API to toggle.
     */
    fun toggleAPI(apiType: ApiType) {
        val index = _platformState.value.indexOfFirst { it.name == apiType }

        if (index >= 0) {
            _platformState.update {
                it.mapIndexed { i, p ->
                    if (index == i) {
                        p.copy(enabled = p.enabled.not())
                    } else {
                        p
                    }
                }
            }
            viewModelScope.launch {
                settingRepository.updatePlatforms(_platformState.value)
            }
        }
    }

    /**
     * Saves the platform settings.
     */
    fun savePlatformSettings() {
        viewModelScope.launch {
            settingRepository.updatePlatforms(_platformState.value)
        }
    }

    /**
     * Updates the API URL for a platform.
     *
     * @param apiType The type of the API.
     * @param url The new URL.
     */
    fun updateURL(apiType: ApiType, url: String) {
        val index = _platformState.value.indexOfFirst { it.name == apiType }

        if (index >= 0) {
            _platformState.update {
                it.mapIndexed { i, p ->
                    if (index == i && url.isNotBlank()) {
                        p.copy(apiUrl = url)
                    } else {
                        p
                    }
                }
            }
        }
    }

    /**
     * Updates the API token for a platform.
     *
     * @param apiType The type of the API.
     * @param token The new token.
     */
    fun updateToken(apiType: ApiType, token: String) {
        val index = _platformState.value.indexOfFirst { it.name == apiType }

        if (index >= 0) {
            _platformState.update {
                it.mapIndexed { i, p ->
                    if (index == i && token.isNotBlank()) {
                        p.copy(token = token)
                    } else {
                        p
                    }
                }
            }
        }
    }

    /**
     * Updates the model for a platform.
     *
     * @param apiType The type of the API.
     * @param model The new model.
     */
    fun updateModel(apiType: ApiType, model: String) {
        val index = _platformState.value.indexOfFirst { it.name == apiType }

        if (index >= 0) {
            _platformState.update {
                it.mapIndexed { i, p ->
                    if (index == i) {
                        p.copy(model = model)
                    } else {
                        p
                    }
                }
            }
        }
    }

    /**
     * Updates the temperature for a platform.
     *
     * @param apiType The type of the API.
     * @param temperature The new temperature.
     */
    fun updateTemperature(apiType: ApiType, temperature: Float) {
        val index = _platformState.value.indexOfFirst { it.name == apiType }
        val modifiedTemperature = when (apiType) {
            ApiType.ANTHROPIC -> temperature.coerceIn(0F, 1F)
            else -> temperature.coerceIn(0F, 2F)
        }

        if (index >= 0) {
            _platformState.update {
                it.mapIndexed { i, p ->
                    if (index == i) {
                        p.copy(temperature = modifiedTemperature)
                    } else {
                        p
                    }
                }
            }
        }
    }

    /**
     * Updates the top-p value for a platform.
     *
     * @param apiType The type of the API.
     * @param topP The new top-p value.
     */
    fun updateTopP(apiType: ApiType, topP: Float) {
        val index = _platformState.value.indexOfFirst { it.name == apiType }
        val modifiedTopP = topP.coerceIn(0.1F, 1F)

        if (index >= 0) {
            _platformState.update {
                it.mapIndexed { i, p ->
                    if (index == i) {
                        p.copy(topP = modifiedTopP)
                    } else {
                        p
                    }
                }
            }
        }
    }

    /**
     * Updates the system prompt for a platform.
     *
     * @param apiType The type of the API.
     * @param prompt The new system prompt.
     */
    fun updateSystemPrompt(apiType: ApiType, prompt: String) {
        val index = _platformState.value.indexOfFirst { it.name == apiType }

        if (index >= 0) {
            _platformState.update {
                it.mapIndexed { i, p ->
                    if (index == i && prompt.isNotBlank()) {
                        p.copy(systemPrompt = prompt)
                    } else {
                        p
                    }
                }
            }
        }
    }

    /**
     * Opens the theme dialog.
     */
    fun openThemeDialog() = _dialogState.update { it.copy(isThemeDialogOpen = true) }

    /**
     * Opens the API URL dialog.
     */
    fun openApiUrlDialog() = _dialogState.update { it.copy(isApiUrlDialogOpen = true) }

    /**
     * Opens the API token dialog.
     */
    fun openApiTokenDialog() = _dialogState.update { it.copy(isApiTokenDialogOpen = true) }

    /**
     * Opens the API model dialog.
     */
    fun openApiModelDialog() = _dialogState.update { it.copy(isApiModelDialogOpen = true) }

    /**
     * Opens the temperature dialog.
     */
    fun openTemperatureDialog() = _dialogState.update { it.copy(isTemperatureDialogOpen = true) }

    /**
     * Opens the top-p dialog.
     */
    fun openTopPDialog() = _dialogState.update { it.copy(isTopPDialogOpen = true) }

    /**
     * Opens the system prompt dialog.
     */
    fun openSystemPromptDialog() = _dialogState.update { it.copy(isSystemPromptDialogOpen = true) }

    /**
     * Closes the theme dialog.
     */
    fun closeThemeDialog() = _dialogState.update { it.copy(isThemeDialogOpen = false) }

    /**
     * Closes the API URL dialog.
     */
    fun closeApiUrlDialog() = _dialogState.update { it.copy(isApiUrlDialogOpen = false) }

    /**
     * Closes the API token dialog.
     */
    fun closeApiTokenDialog() = _dialogState.update { it.copy(isApiTokenDialogOpen = false) }

    /**
     * Closes the API model dialog.
     */
    fun closeApiModelDialog() = _dialogState.update { it.copy(isApiModelDialogOpen = false) }

    /**
     * Closes the temperature dialog.
     */
    fun closeTemperatureDialog() = _dialogState.update { it.copy(isTemperatureDialogOpen = false) }

    /**
     * Closes the top-p dialog.
     */
    fun closeTopPDialog() = _dialogState.update { it.copy(isTopPDialogOpen = false) }

    /**
     * Closes the system prompt dialog.
     */
    fun closeSystemPromptDialog() = _dialogState.update { it.copy(isSystemPromptDialogOpen = false) }

    private fun fetchPlatformStatus() {
        viewModelScope.launch {
            val platforms = settingRepository.fetchPlatforms()
            _platformState.update { platforms }
        }
    }

    /**
     * The state of the dialogs.
     *
     * @property isThemeDialogOpen Whether the theme dialog is open.
     * @property isApiUrlDialogOpen Whether the API URL dialog is open.
     * @property isApiTokenDialogOpen Whether the API token dialog is open.
     * @property isApiModelDialogOpen Whether the API model dialog is open.
     * @property isTemperatureDialogOpen Whether the temperature dialog is open.
     * @property isTopPDialogOpen Whether the top-p dialog is open.
     * @property isSystemPromptDialogOpen Whether the system prompt dialog is open.
     */
    data class DialogState(
        val isThemeDialogOpen: Boolean = false,
        val isApiUrlDialogOpen: Boolean = false,
        val isApiTokenDialogOpen: Boolean = false,
        val isApiModelDialogOpen: Boolean = false,
        val isTemperatureDialogOpen: Boolean = false,
        val isTopPDialogOpen: Boolean = false,
        val isSystemPromptDialogOpen: Boolean = false
    )
}
