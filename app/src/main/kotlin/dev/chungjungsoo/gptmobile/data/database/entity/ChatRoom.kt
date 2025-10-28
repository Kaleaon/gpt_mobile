package dev.chungjungsoo.gptmobile.data.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import dev.chungjungsoo.gptmobile.data.model.ApiType
import kotlinx.parcelize.Parcelize

/**
 * A data class that represents a chat room.
 *
 * @property id The ID of the chat room.
 * @property title The title of the chat room.
 * @property enabledPlatform The list of enabled platforms for the chat room.
 * @property createdAt The timestamp when the chat room was created.
 */
@Parcelize
@Entity(tableName = "chats")
data class ChatRoom(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "chat_id")
    val id: Int = 0,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "enabled_platform")
    val enabledPlatform: List<ApiType>,

    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis() / 1000
) : Parcelable

/**
 * A type converter for the [ApiType] enum.
 */
class APITypeConverter {
    /**
     * Converts a string to a list of [ApiType]s.
     *
     * @param value The string to convert.
     * @return The list of [ApiType]s.
     */
    @TypeConverter
    fun fromString(value: String): List<ApiType> {
        val splitted = value.split(',')

        return splitted.map { s -> ApiType.valueOf(s) }
    }

    /**
     * Converts a list of [ApiType]s to a string.
     *
     * @param value The list of [ApiType]s to convert.
     * @return The string representation of the list.
     */
    @TypeConverter
    fun fromList(value: List<ApiType>): String = value.joinToString(",") { v -> v.name }
}
