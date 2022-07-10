import java.io.File

/** GITHUB_ENV */
val githubEnvPath = System.getenv("GITHUB_ENV")

println("ENV_PATH: $githubEnvPath")

val githubEnvFile = File(githubEnvPath)

val currentEnvText = githubEnvFile.readText()

println("CURRENT_ENV_TEXT:\n$currentEnvText")

githubEnvFile.putEnvironmentVariable("HELLO-ENV", "HI ENV")

println("CURRENT_ENV_TEXT:\n${githubEnvFile.readText()}")

/** GITHUB_OUTPUT */
val githubOutputPath = System.getenv("GITHUB_OUTPUT")

println("OUTPUT_PATH: $githubOutputPath")

val githubOutputFile = File(githubOutputPath)

val currentOutputText = githubOutputFile.readText()

println("CURRENT_OUTPUT_TEXT:\n$currentOutputText")

githubOutputFile.putEnvironmentVariable("HELLO-OUTPUT", "HI OUTPUT")

println("CURRENT_OUTPUT_TEXT:\n${githubOutputFile.readText()}")

/** Implementation details */
fun File.putEnvironmentVariable(key: String, value: String) {
    val lines = readLines().toMutableList()
    val keyIndex = lines.indexOfFirst { line -> line.substringBefore('=') == key }
    if (keyIndex != -1) lines[keyIndex] = value else lines.add("$key=$value")
    writeText(lines.joinToString("\n"))
}
