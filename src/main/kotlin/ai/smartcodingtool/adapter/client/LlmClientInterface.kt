package ai.smartcodingtool.adapter.client

import ai.smartcodingtool.domain.InputFile
import ai.smartcodingtool.domain.LlmDirective
import ai.smartcodingtool.domain.OutputFile

interface LlmClientInterface {
    suspend fun generate(inputFiles: List<InputFile>, directives: LlmDirective): List<OutputFile>
}