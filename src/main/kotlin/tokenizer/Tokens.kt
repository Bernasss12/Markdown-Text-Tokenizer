/*
 * MIT License
 *
 * Copyright (c) 2019 Bernado Antunes
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package tokenizer

import java.awt.Color

sealed class IToken

/* Normal Token that stores the text and the formatting tags of said text. */
class Token(var str: String, private val tags: MutableList<Tokenizer.TokenTag>, val color: Color = Color.WHITE) : IToken() {
    override fun toString(): String {
        val opt = if (color != Color.WHITE) "| Color: ${color.toString()} " else ""
        return "Text: $str | Tags: $tags $opt"
    }
}

/* Header token, stores all the tokens that are apart of the header. */
class TokenHeader(val tokens: MutableList<IToken>) : IToken() {
    // Debugging purposes only
    override fun toString(): String {
        var str = "\nHeader -↓-        \n"
        tokens.forEach {
            str += "$it\n"
        }
        str += "Header -↑-        \n"
        return str
    }
}

/* Image token, stores a token list in case the image is not correctly loaded as well as the image's path*/
class TokenImage(val tokens: MutableList<IToken>, val url: String) : IToken() {
    override fun toString(): String {
        var alt = "\nImage -↓-        \n Tokens: \n"
        tokens.forEach {
            alt += "$it\n"
        }
        return "$alt\nPath: $url \nImage -↑-        \n"
    }
}

/* Link token, stores the linked string, as well as the 'url'. */
class TokenLink(val str: String, val url: String) : IToken() {
    override fun toString(): String {
        return "Text: \"$str\" | Target: \"$url\""
    }
}

/* Item token, stores the alternative name, in case the item is not recognized, as well as the unlocalized name of the desired item */
class TokenItem(val name: String, val item: String) : IToken() {
    override fun toString(): String {
        return "Name: \"$name\" | Target item: \"$item\""
    }
}

/* LineBreak token, simply represents a line break in the text. */
class TokenLineBreak : IToken() {
    override fun toString(): String {
        return "Linebreak: \\n"
    }
}

/* Stores the text and the type of paragraph. */
class Paragraph(var str: String, var type: ParagraphType) {
    override fun toString(): String {
        return "$str | $type"
    }
}

enum class ParagraphType {
    Text,
    Header,
    Image
}