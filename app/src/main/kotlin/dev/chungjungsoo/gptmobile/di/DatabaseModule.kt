package dev.chungjungsoo.gptmobile.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.chungjungsoo.gptmobile.data.database.ChatDatabase
import dev.chungjungsoo.gptmobile.data.database.dao.ChatRoomDao
import dev.chungjungsoo.gptmobile.data.database.dao.MessageDao
import javax.inject.Singleton

/**
 * A Hilt module for providing the database.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val DB_NAME = "chat"

    /**
     * Provides the chat room DAO.
     *
     * @param chatDatabase The chat database.
     * @return The chat room DAO.
     */
    @Provides
    fun provideChatRoomDao(chatDatabase: ChatDatabase): ChatRoomDao = chatDatabase.chatRoomDao()

    /**
     * Provides the message DAO.
     *
     * @param chatDatabase The chat database.
     * @return The message DAO.
     */
    @Provides
    fun provideMessageDao(chatDatabase: ChatDatabase): MessageDao = chatDatabase.messageDao()

    /**
     * Provides the chat database.
     *
     * @param appContext The application context.
     * @return The chat database.
     */
    @Provides
    @Singleton
    fun provideChatDatabase(@ApplicationContext appContext: Context): ChatDatabase = Room.databaseBuilder(
        appContext,
        ChatDatabase::class.java,
        DB_NAME
    ).build()
}
