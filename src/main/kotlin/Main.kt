import tokenizer.Tokenizer

fun main(args: Array<String>) {
    val unformatted =
        (ClassLoader.getSystemClassLoader().getResourceAsStream("files/page0.md")
            ?: error("Couldn't load files/page0.md")).bufferedReader().readLines()
            .joinToString("\n")

    val paragraphs = Tokenizer.tokenize(unformatted)
    println(paragraphs)
}