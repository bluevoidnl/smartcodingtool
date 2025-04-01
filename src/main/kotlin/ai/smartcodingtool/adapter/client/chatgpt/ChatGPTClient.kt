package ai.smartcodingtool.adapter.client.chatgpt

import ai.smartcodingtool.adapter.client.LlmClientInterface
import ai.smartcodingtool.domain.LLMDirective
import ai.smartcodingtool.domain.OutputFile
import java.io.File

class ChatGPTClient: LlmClientInterface {
    override suspend fun generate(inputFiles: List<File>, directives: LLMDirective): List<OutputFile> {
        TODO("Not yet implemented")
    }
}