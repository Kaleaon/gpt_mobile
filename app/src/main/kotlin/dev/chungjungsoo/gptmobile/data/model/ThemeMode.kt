package dev.chungjungsoo.gptmobile.data.model

/**
 * An enum that represents the theme mode of the application.
 */
enum class ThemeMode {
    /**
     * The system theme mode.
     */
    SYSTEM,
    /**
     * The dark theme mode.
     */
    DARK,
    /**
     * The light theme mode.
     */
    LIGHT;

    /**
     * A companion object for the [ThemeMode] enum.
     */
    companion object {
        /**
         * Returns the [ThemeMode] for the given value.
         *
         * @param value The value to get the [ThemeMode] for.
         * @return The [ThemeMode] for the given value.
         */
        fun getByValue(value: Int) = entries.firstOrNull { it.ordinal == value }
    }
}
