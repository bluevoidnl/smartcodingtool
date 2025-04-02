// alphabetical order
val dotenvKotlinVersion = "6.5.1"
val ktorVersion = "2.3.2"
val openAiClientVersion = "3.8.2"

plugins {
    kotlin("jvm") version "2.0.21"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // alphabetical order
    implementation("com.aallam.openai:openai-client:$openAiClientVersion")
    implementation("io.github.cdimascio:dotenv-kotlin:$dotenvKotlinVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-core:$ktorVersion")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
