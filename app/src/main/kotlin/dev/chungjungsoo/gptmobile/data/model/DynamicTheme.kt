package dev.chungjungsoo.gptmobile.data.model

/**
 * An enum that represents the dynamic theme setting.
 */
enum class DynamicTheme {
    /**
     * The dynamic theme is on.
     */
    ON,
    /**
     * The dynamic theme is off.
     */
    OFF;

    /**
     * A companion object for the [DynamicTheme] enum.
     */
    companion object {
        /**
         * Returns the [DynamicTheme] for the given value.
         *
         * @param value The value to get the [DynamicTheme] for.
         * @return The [DynamicTheme] for the given value.
         */
        fun getByValue(value: Int) = entries.firstOrNull { it.ordinal == value }
    }
}
