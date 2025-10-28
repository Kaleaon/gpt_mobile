package dev.chungjungsoo.gptmobile.presentation

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * The main application class.
 */
@HiltAndroidApp
class GPTMobileApp : Application() {
    // TODO Delete when https://github.com/google/dagger/issues/3601 is resolved.
    /**
     * The application context.
     */
    @Inject
    @ApplicationContext
    lateinit var context: Context
}
