package ai.smartcodingtool.adapter.client

abstract class BaseLlm(
    val provider: String,
    val name: String,
    val modelInfo: ModelInfo
)

sealed class OpenAiLlm(modelInfo: ModelInfo) : BaseLlm(
    name = "GPT",
    provider = "OpenAi",
    modelInfo = modelInfo
) {
    object OpenAiGpt4O : OpenAiLlm(
        ModelInfo(
            modelId = "gpt-4o",
            version = "1",
            maxTokens = 40000
        )
    )
    object OpenAiGpt4Omini : OpenAiLlm(
        ModelInfo(
            modelId = "gpt-4o-mini",
            version = "1",
            maxTokens = 40000
        )
    )
}

data class ModelInfo(
    val modelId: String,
    val version: String,
    val maxTokens: Int
)