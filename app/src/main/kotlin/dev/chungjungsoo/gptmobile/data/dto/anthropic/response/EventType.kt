package dev.chungjungsoo.gptmobile.data.dto.anthropic.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An enum that represents the type of an event.
 */
@Serializable
enum class EventType {

    /**
     * A message start event.
     */
    @SerialName("message_start")
    MESSAGE_START,

    /**
     * A content block start event.
     */
    @SerialName("content_block_start")
    CONTENT_START,

    /**
     * A content block delta event.
     */
    @SerialName("content_block_delta")
    CONTENT_DELTA,

    /**
     * A content block stop event.
     */
    @SerialName("content_block_stop")
    CONTENT_STOP,

    /**
     * A message delta event.
     */
    @SerialName("message_delta")
    MESSAGE_DELTA,

    /**
     * A message stop event.
     */
    @SerialName("message_stop")
    MESSAGE_STOP,

    /**
     * A ping event.
     */
    @SerialName("ping")
    PING,

    /**
     * An error event.
     */
    @SerialName("error")
    ERROR
}
