package ai.smartcodingtool.domain

import java.io.File

class InputFile(val name: String, val content: String) {


    companion object {
        fun fromFile(inputFile: File, fileName: String): InputFile {
            if (!inputFile.exists()) {
                throw IllegalArgumentException("file does not exist:" + inputFile.absolutePath)
            }
            val inputText = inputFile.readText(Charsets.UTF_8)
            return InputFile(fileName, inputText)
        }
    }
}
