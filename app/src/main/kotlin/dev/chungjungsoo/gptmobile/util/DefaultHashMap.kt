package dev.chungjungsoo.gptmobile.util

/**
 * A [HashMap] that returns a default value when a key is not found.
 *
 * This is a small implementation of HashMap, but with default values.
 * This way the get operator will not throw an error or null.
 * Inspired by Python collections DefaultDict.
 *
 * @param K The type of the keys.
 * @param V The type of the values.
 * @property defaultValueProvider A function that provides the default value.
 */
open class DefaultHashMap<K, V>(protected val defaultValueProvider: () -> V) : HashMap<K, V>() {
    override operator fun get(key: K): V {
        if (key in this) {
            return super.get(key)!!
        }

        val defaultValue = defaultValueProvider()
        this[key] = defaultValue
        return super.get(key)!!
    }
}
