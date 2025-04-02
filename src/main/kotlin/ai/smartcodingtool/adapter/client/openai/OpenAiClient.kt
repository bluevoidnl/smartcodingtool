package ai.smartcodingtool.adapter.client.openai

import ai.smartcodingtool.adapter.client.LlmClientException
import ai.smartcodingtool.adapter.client.LlmClientInterface
import ai.smartcodingtool.config.EnvConfig
import ai.smartcodingtool.domain.InputFile
import ai.smartcodingtool.domain.LlmDirective
import ai.smartcodingtool.domain.OutputFile
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.chat.chatCompletionRequest
import com.aallam.openai.api.http.Timeout
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import com.aallam.openai.client.OpenAIConfig
import kotlin.time.Duration.Companion.seconds

class OpenAiClient : LlmClientInterface {

    private val envConfig = EnvConfig

    private val config = OpenAIConfig(
        token = envConfig.openAiApiKey,
        timeout = Timeout(socket = 60.seconds),
    )

    private val openAi = OpenAI(config)

    override suspend fun generate(inputFiles: List<InputFile>, directives: LlmDirective): List<OutputFile> {

        val prompt = inputFiles.joinToString(separator = "\n\n") {
            "Filename: " + it.name + "\nFileContent: " + it.content
        }

        val chatCompletionRequest = chatCompletionRequest {
            model = ModelId(directives.model.name)
            messages = listOf(
                ChatMessage(
                    role = ChatRole.System,
                    content = "You are a helpful assistant that can generate code based on tests, that must compile correctly "//directives.getSystemPrompt()
                ),
                ChatMessage(role = ChatRole.User, content = prompt),
            )
        }
        val completion = openAi.chatCompletion(chatCompletionRequest)

        val content = completion.choices[0].message.content ?: throw LlmClientException("no outputfile generated")

        return listOf(OutputFile("testclass", content))
    }
}