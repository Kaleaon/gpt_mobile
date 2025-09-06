package dev.chungjungsoo.gptmobile.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.chungjungsoo.gptmobile.data.datastore.SettingDataSource
import dev.chungjungsoo.gptmobile.data.repository.SettingRepository
import dev.chungjungsoo.gptmobile.data.repository.SettingRepositoryImpl
import javax.inject.Singleton

/**
 * A Hilt module for providing the setting repository.
 */
@Module
@InstallIn(SingletonComponent::class)
object SettingRepositoryModule {

    /**
     * Provides the setting repository.
     *
     * @param settingDataSource The data source for the settings.
     * @return The setting repository.
     */
    @Provides
    @Singleton
    fun provideSettingRepository(
        settingDataSource: SettingDataSource
    ): SettingRepository = SettingRepositoryImpl(settingDataSource)
}
