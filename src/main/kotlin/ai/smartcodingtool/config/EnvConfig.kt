package ai.smartcodingtool.config

import io.github.cdimascio.dotenv.dotenv

object EnvConfig {

    private val dotenv = dotenv {
        ignoreIfMissing = true // allow missing .env file (useful in production)
        ignoreIfMalformed = true
    }

    /*
    Get environment variables in the following order;
      - first, check if the environment variable exists in System.getenv() (useful in CI/CD with GitHub Secrets or Docker)
      - if not found, check the .env file (for local development)
      - if neither is found, return a default value.
     */

    val openAiApiKey: String
        get() = System.getenv("OPEN_AI_API_KEY") ?: dotenv["OPEN_AI_API_KEY"] ?: "no-key-found"

}