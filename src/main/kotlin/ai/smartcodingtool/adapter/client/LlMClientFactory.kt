package ai.smartcodingtool.adapter.client

import ai.smartcodingtool.adapter.client.openai.OpenAiClient

object LlMClientFactory {

    fun getClient(client: BaseLlm): LlmClientInterface {
        return when (client) {
           is OpenAiLlm -> OpenAiClient()
            else -> throw UnsupportedOperationException()
        }
    }
}