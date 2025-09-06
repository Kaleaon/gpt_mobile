package dev.chungjungsoo.gptmobile.util

import android.util.Patterns
import android.webkit.URLUtil

/**
 * Returns whether the string is a valid URL.
 *
 * @return `true` if the string is a valid URL, `false` otherwise.
 */
fun String.isValidUrl(): Boolean = URLUtil.isValidUrl(this) && Patterns.WEB_URL.matcher(this).matches()
