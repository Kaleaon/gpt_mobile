package dev.chungjungsoo.gptmobile.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import dev.chungjungsoo.gptmobile.data.database.entity.ChatRoom

/**
 * The DAO for the chat room table.
 */
@Dao
interface ChatRoomDao {

    /**
     * Returns all chat rooms from the database.
     *
     * @return A list of all chat rooms.
     */
    @Query("SELECT * FROM chats ORDER BY created_at DESC")
    suspend fun getChatRooms(): List<ChatRoom>

    /**
     * Adds a new chat room to the database.
     *
     * @param chatRoom The chat room to add.
     * @return The ID of the new chat room.
     */
    @Insert
    suspend fun addChatRoom(chatRoom: ChatRoom): Long

    /**
     * Edits an existing chat room in the database.
     *
     * @param chatRoom The chat room to edit.
     */
    @Update
    suspend fun editChatRoom(chatRoom: ChatRoom)

    /**
     * Deletes one or more chat rooms from the database.
     *
     * @param chatRooms The chat rooms to delete.
     */
    @Delete
    suspend fun deleteChatRooms(vararg chatRooms: ChatRoom)
}
