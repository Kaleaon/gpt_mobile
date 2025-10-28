package dev.chungjungsoo.gptmobile.presentation.common

/**
 * An object that contains all the routes used in the application.
 */
object Route {

    /**
     * The route for the get started screen.
     */
    const val GET_STARTED = "get_started"

    /**
     * The route for the setup flow.
     */
    const val SETUP_ROUTE = "setup_route"
    /**
     * The route for the select platform screen.
     */
    const val SELECT_PLATFORM = "select_platform"
    /**
     * The route for the token input screen.
     */
    const val TOKEN_INPUT = "token_input"
    /**
     * The route for the OpenAI model select screen.
     */
    const val OPENAI_MODEL_SELECT = "openai_model_select"
    /**
     * The route for the Anthropic model select screen.
     */
    const val ANTHROPIC_MODEL_SELECT = "anthropic_model_select"
    /**
     * The route for the Google model select screen.
     */
    const val GOOGLE_MODEL_SELECT = "google_model_select"
    /**
     * The route for the Groq model select screen.
     */
    const val GROQ_MODEL_SELECT = "groq_model_select"
    /**
     * The route for the Ollama model select screen.
     */
    const val OLLAMA_MODEL_SELECT = "ollama_model_select"
    /**
     * The route for the Ollama API address screen.
     */
    const val OLLAMA_API_ADDRESS = "ollama_api_address"
    /**
     * The route for the setup complete screen.
     */
    const val SETUP_COMPLETE = "setup_complete"

    /**
     * The route for the chat list screen.
     */
    const val CHAT_LIST = "chat_list"
    /**
     * The route for the chat room screen.
     */
    const val CHAT_ROOM = "chat_room/{chatRoomId}?enabled={enabledPlatforms}"

    /**
     * The route for the settings flow.
     */
    const val SETTING_ROUTE = "setting_route"
    /**
     * The route for the settings screen.
     */
    const val SETTINGS = "settings"
    /**
     * The route for the OpenAI settings screen.
     */
    const val OPENAI_SETTINGS = "openai_settings"
    /**
     * The route for the Anthropic settings screen.
     */
    const val ANTHROPIC_SETTINGS = "anthropic_settings"
    /**
     * The route for the Google settings screen.
     */
    const val GOOGLE_SETTINGS = "google_settings"
    /**
     * The route for the Groq settings screen.
     */
    const val GROQ_SETTINGS = "groq_settings"
    /**
     * The route for the Ollama settings screen.
     */
    const val OLLAMA_SETTINGS = "ollama_settings"
    /**
     * The route for the about page.
     */
    const val ABOUT_PAGE = "about"
    /**
     * The route for the license screen.
     */
    const val LICENSE = "license"
}
