import tokenizer.Tokenizer
import java.io.File

fun main(args: Array<String>) {
    val unformatted =
        File("C:\\Development\\Kotlin\\Tokenizer\\src\\files\\page0.md").inputStream().bufferedReader().readLines()
            .joinToString("\n")

    val paragraphs = Tokenizer.tokenize(unformatted)
    println(paragraphs)
}