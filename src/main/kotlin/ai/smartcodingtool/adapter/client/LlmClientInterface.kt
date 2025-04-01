package ai.smartcodingtool.adapter.client

import ai.smartcodingtool.domain.LLMDirective
import ai.smartcodingtool.domain.OutputFile
import java.io.File

interface LlmClientInterface {
    suspend fun generate(inputFiles: List<File>, directives: LLMDirective): List<OutputFile>
}