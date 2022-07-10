import java.io.File

val githubEnvPath = System.getenv("GITHUB_ENV")

println("PATH: $githubEnvPath")

val githubEnvFile = File(githubEnvPath)

val currentText = githubEnvFile.readText()

println("CURRENT_TEXT:\n$currentText")

val updatedText = currentText + "\nHELLO=hola"

githubEnvFile.writeText(updatedText)

println("CURRENT_TEXT:\n${githubEnvFile.readText()}")
