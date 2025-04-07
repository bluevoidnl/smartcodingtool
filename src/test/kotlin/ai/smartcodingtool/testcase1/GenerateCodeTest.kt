package ai.smartcodingtool.testcase1

import ai.smartcodingtool.adapter.client.LlMClientFactory
import ai.smartcodingtool.adapter.client.OpenAiLlm
import ai.smartcodingtool.domain.InputFile
import ai.smartcodingtool.domain.LlmDirective
import kotlinx.coroutines.runBlocking
import java.io.File
import kotlin.test.Test

class GenerateCodeTest {

    private val base = File("src/test/kotlin")

    @Test
    fun dummyTest() {

        val testFileName = "ai/smartcodingtool/testcase1/RangeUtilTest.kt"
        val outputFileName = "ai/smartcodingtool/testcase1/RangeUtil.kt"
        val inputFile = InputFile.fromFile(File(base, testFileName), testFileName)

        val model = OpenAiLlm.OpenAiGpt4O
        val client = LlMClientFactory.getClient(model)
        val directive = LlmDirective(
            model = model,
            outputCodeLanguage = "Kotlin",
            userPrompt = "You are a helpful assistant that generates compiling and correct code based on ALL! tests. " +
                    "Read all the tests and reason about the code before generating the code."+
                    "Only return the code content of the file, nothing else, not even the fact that it is kotlin."
        )

        runBlocking {
            val outputFiles = client.generate(inputFiles = listOf(inputFile), directive = directive)

            outputFiles.forEach {
                println(it.name + "   ---------------------------")
                println(it.content)
            }

            File(base, outputFileName).writeText(outputFiles[0].content, Charsets.UTF_8)
        }
    }
}
