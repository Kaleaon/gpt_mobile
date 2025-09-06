package dev.chungjungsoo.gptmobile.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import dev.chungjungsoo.gptmobile.data.database.entity.Message

/**
 * The DAO for the message table.
 */
@Dao
interface MessageDao {

    /**
     * Returns all messages from the database for a given chat.
     *
     * @param chatInt The ID of the chat.
     * @return A list of all messages for the given chat.
     */
    @Query("SELECT * FROM messages WHERE chat_id=:chatInt")
    suspend fun loadMessages(chatInt: Int): List<Message>

    /**
     * Adds one or more messages to the database.
     *
     * @param messages The messages to add.
     */
    @Insert
    suspend fun addMessages(vararg messages: Message)

    /**
     * Edits one or more messages in the database.
     *
     * @param message The messages to edit.
     */
    @Update
    suspend fun editMessages(vararg message: Message)

    /**
     * Deletes one or more messages from the database.
     *
     * @param message The messages to delete.
     */
    @Delete
    suspend fun deleteMessages(vararg message: Message)
}
