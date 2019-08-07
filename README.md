# Kotlin Markdown Tokenizer

Made to quickly test and improve a tokenizer used in [Logistics Pipes](https://github.com/RS485/LogisticsPipes).

####Used tags are as follows:
##### Normal tags, used like "\_this\_" = "_this_"
```
#         → Header
* or _    → Italic
** or __  → Bold
~~        → Strikethrough
~         → Underlined
^         → Shadowed
```
##### Special tags, used like \[par1](par2)
```
[Text Link](Url)
+[Desired Colored Text](Color, either name or Hex)
![Alternative text](image path)
$[Item name](item:unlocalized_name)
```