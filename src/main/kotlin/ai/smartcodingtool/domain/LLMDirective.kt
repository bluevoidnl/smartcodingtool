package ai.smartcodingtool.domain

data class LLMDirective(
    val systemPrompt: String,
    val modelName: String
)