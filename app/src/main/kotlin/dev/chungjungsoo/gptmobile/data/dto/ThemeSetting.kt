package dev.chungjungsoo.gptmobile.data.dto

import dev.chungjungsoo.gptmobile.data.model.DynamicTheme
import dev.chungjungsoo.gptmobile.data.model.ThemeMode

/**
 * A data class that represents the theme settings.
 *
 * @property dynamicTheme The dynamic theme setting.
 * @property themeMode The theme mode setting.
 */
data class ThemeSetting(
    val dynamicTheme: DynamicTheme = DynamicTheme.OFF,
    val themeMode: ThemeMode = ThemeMode.SYSTEM
)
