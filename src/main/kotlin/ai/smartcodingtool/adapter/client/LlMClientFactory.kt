package ai.smartcodingtool.adapter.client

import ai.smartcodingtool.adapter.client.chatgpt.ChatGPTClient

object LlMClientFactory {

    fun getClient(client: LlmClient): LlmClientInterface {
        return when (client) {
            LlmClient.ChatGPT -> ChatGPTClient()
        }
    }
}