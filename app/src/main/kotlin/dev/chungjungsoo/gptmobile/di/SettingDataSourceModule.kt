package dev.chungjungsoo.gptmobile.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.chungjungsoo.gptmobile.data.datastore.SettingDataSource
import dev.chungjungsoo.gptmobile.data.datastore.SettingDataSourceImpl
import javax.inject.Singleton

/**
 * A Hilt module for providing the setting data source.
 */
@Module
@InstallIn(SingletonComponent::class)
object SettingDataSourceModule {
    /**
     * Provides the setting data source.
     *
     * @param dataStore The data store for the settings.
     * @return The setting data source.
     */
    @Provides
    @Singleton
    fun provideSettingDataStore(dataStore: DataStore<Preferences>): SettingDataSource = SettingDataSourceImpl(dataStore)
}
