package dev.chungjungsoo.gptmobile.data

import dev.chungjungsoo.gptmobile.data.model.ApiType

/**
 * An object that contains constants for the models.
 */
object ModelConstants {
    // LinkedHashSet should be used to guarantee item order
    /**
     * The set of OpenAI models.
     */
    val openaiModels = linkedSetOf("gpt-4o", "gpt-4o-mini", "gpt-4-turbo", "gpt-4")
    /**
     * The set of Anthropic models.
     */
    val anthropicModels = linkedSetOf("claude-3-5-sonnet-20240620", "claude-3-opus-20240229", "claude-3-sonnet-20240229", "claude-3-haiku-20240307")
    /**
     * The set of Google models.
     */
    val googleModels = linkedSetOf("gemini-1.5-pro-latest", "gemini-1.5-flash-latest", "gemini-1.0-pro")
    /**
     * The set of Groq models.
     */
    val groqModels = linkedSetOf("llama-3.2-3b-preview", "llama-3.2-1b-preview", "llama-3.1-70b-versatile", "llama-3.1-8b-instant", "gemma2-9b-it")
    /**
     * The set of Ollama models.
     */
    val ollamaModels = linkedSetOf<String>()

    /**
     * The base URL for the OpenAI API.
     */
    const val OPENAI_API_URL = "https://api.openai.com/v1/"
    /**
     * The base URL for the Anthropic API.
     */
    const val ANTHROPIC_API_URL = "https://api.anthropic.com/"
    /**
     * The base URL for the Google API.
     */
    const val GOOGLE_API_URL = "https://generativelanguage.googleapis.com"
    /**
     * The base URL for the Groq API.
     */
    const val GROQ_API_URL = "https://api.groq.com/openai/v1/"

    /**
     * Returns the default API URL for the given API type.
     *
     * @param apiType The type of the API.
     * @return The default API URL.
     */
    fun getDefaultAPIUrl(apiType: ApiType) = when (apiType) {
        ApiType.OPENAI -> OPENAI_API_URL
        ApiType.ANTHROPIC -> ANTHROPIC_API_URL
        ApiType.GOOGLE -> GOOGLE_API_URL
        ApiType.GROQ -> GROQ_API_URL
        ApiType.OLLAMA -> ""
    }

    /**
     * The maximum number of tokens for the Anthropic API.
     */
    const val ANTHROPIC_MAXIMUM_TOKEN = 4096

    /**
     * The default system prompt for the OpenAI API.
     */
    const val OPENAI_PROMPT =
        "You are a helpful, clever, and very friendly assistant. " +
            "You are familiar with various languages in the world. " +
            "You are to answer my questions precisely. "

    /**
     * The default system prompt.
     */
    const val DEFAULT_PROMPT = "Your task is to answer my questions precisely."

    /**
     * The prompt for generating a chat title.
     */
    const val CHAT_TITLE_GENERATE_PROMPT =
        "Create a title that summarizes the chat. " +
            "The output must match the language that the user and the opponent is using, and should be less than 50 letters. " +
            "The output should only include the sentence in plain text without bullets or double asterisks. Do not use markdown syntax.\n" +
            "[Chat Content]\n"
}
