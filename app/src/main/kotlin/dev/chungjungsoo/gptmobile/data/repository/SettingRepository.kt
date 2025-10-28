package dev.chungjungsoo.gptmobile.data.repository

import dev.chungjungsoo.gptmobile.data.dto.Platform
import dev.chungjungsoo.gptmobile.data.dto.ThemeSetting

/**
 * An interface for the setting repository.
 */
interface SettingRepository {
    /**
     * Fetches the list of platforms.
     *
     * @return A list of platforms.
     */
    suspend fun fetchPlatforms(): List<Platform>
    /**
     * Fetches the theme settings.
     *
     * @return The theme settings.
     */
    suspend fun fetchThemes(): ThemeSetting
    /**
     * Updates the list of platforms.
     *
     * @param platforms The new list of platforms.
     */
    suspend fun updatePlatforms(platforms: List<Platform>)
    /**
     * Updates the theme settings.
     *
     * @param themeSetting The new theme settings.
     */
    suspend fun updateThemes(themeSetting: ThemeSetting)
}
