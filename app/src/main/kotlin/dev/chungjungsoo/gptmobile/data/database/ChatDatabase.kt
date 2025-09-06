package dev.chungjungsoo.gptmobile.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.chungjungsoo.gptmobile.data.database.dao.ChatRoomDao
import dev.chungjungsoo.gptmobile.data.database.dao.MessageDao
import dev.chungjungsoo.gptmobile.data.database.entity.APITypeConverter
import dev.chungjungsoo.gptmobile.data.database.entity.ChatRoom
import dev.chungjungsoo.gptmobile.data.database.entity.Message

/**
 * The Room database for the application.
 */
@Database(entities = [ChatRoom::class, Message::class], version = 1)
@TypeConverters(APITypeConverter::class)
abstract class ChatDatabase : RoomDatabase() {

    /**
     * Returns the DAO for the chat room table.
     *
     * @return The DAO for the chat room table.
     */
    abstract fun chatRoomDao(): ChatRoomDao
    /**
     * Returns the DAO for the message table.
     *
     * @return The DAO for the message table.
     */
    abstract fun messageDao(): MessageDao
}
