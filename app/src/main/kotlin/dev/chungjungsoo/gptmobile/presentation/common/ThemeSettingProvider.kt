package dev.chungjungsoo.gptmobile.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.chungjungsoo.gptmobile.data.model.DynamicTheme
import dev.chungjungsoo.gptmobile.data.model.ThemeMode

/**
 * Composition local for the dynamic theme.
 */
val LocalDynamicTheme = compositionLocalOf { DynamicTheme.OFF }

/**
 * Composition local for the theme mode.
 */
val LocalThemeMode = compositionLocalOf { ThemeMode.SYSTEM }

/**
 * Composition local for the theme view model.
 */
val LocalThemeViewModel = compositionLocalOf<ThemeViewModel> {
    error("CompositionLocal LocalThemeViewModel is not present")
}

/**
 * A composable that provides the theme settings to the content.
 *
 * @param themeViewModel The view model for the theme.
 * @param content The content to be displayed.
 */
@Composable
fun ThemeSettingProvider(
    themeViewModel: ThemeViewModel = hiltViewModel(),
    content: @Composable () -> Unit
) {
    themeViewModel.themeSetting.collectAsStateWithLifecycle().value.run {
        CompositionLocalProvider(
            LocalThemeViewModel provides themeViewModel,
            LocalDynamicTheme provides dynamicTheme,
            LocalThemeMode provides themeMode,
            content = content
        )
    }
}
