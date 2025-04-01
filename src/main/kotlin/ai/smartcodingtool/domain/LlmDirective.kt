package ai.smartcodingtool.domain

import ai.smartcodingtool.adapter.client.BaseLlm

data class LlmDirective(
    val model: BaseLlm,
   // val userPrompt: String,
    val outputCodeLanguage: String
) {

    fun getSystemPrompt(): String {
         // aspects
        // what to generate
    }
}