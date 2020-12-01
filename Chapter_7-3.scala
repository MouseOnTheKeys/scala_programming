// MATCH EXPRESSIONS
/*
Scala’s match expression lets you select from a number of alternatives, just
like switch statements in other languages. In general a match expression
lets you select using arbitrary patterns, which will be described in Chap-
ter 15. The general form can wait. For now, just consider using match to
select among a number of alternatives.
*/

// A match expression with side effects.
val firstArg  = if (!args.isEmpty) args(0) else ""

val friend =
    firstArg match {
        case "salt" => println("pepper")
        case "chips" => println("salsa")
        case "eggs" => println("bacon")
        case _ => println("huh?")
    }
println(friend)

// Living without break and continue

/*
You may have noticed that there has been no mention of break or continue .
Scala leaves out these commands because they do not mesh well with function
literals, a feature described in the next chapter.
*/
var i = 0
var foundIt = false

while (i < args.length && !foundIt) {
    if (!args(i).startsWith("-")) {
        if (args(i).endsWith(".scala"))
            foundIt = true
    }
    i = i + 1
} // Looping without break or continue .

def searchFrom(i: Int): Int =
    if (i >= args.length) -1
    else if (args(i).startsWith("-")) searchFrom(i + 1)
    else if (args(i).endsWith(".scala")) i
    else searchFrom(i + 1)

val i = searchFrom(0) // A recursive alternative to looping with var s.

// REFACTORING IMPERATIVE-STYLE CODE

/* To help you gain insight into the functional style, in this section we’ll refactor
the imperative approach to printing a multiplication table
 */

 // Returns a row as a sequence
def makeRowSeq(row: Int) =
    for (col <- 1 to 10) yield {
        val prod = (row * col).toString
        val padding = " " * (4 - prod.length)
        padding + prod
    }
// Returns a row as a string
def makeRow(row: Int) = makeRowSeq(row).mkString

// Returns table as a string with one row per line
def multiTable() = {
    val tableSeq = // a sequence of row strings
        for (row <- 1 to 10)
        yield makeRow(row)
    tableSeq.mkString("\n")
} // A functional way to create a multiplication table.

/*
Scala’s built-in control structures are minimal, but they do the job. They
act much like their imperative equivalents, but because they tend to result
in a value, they support a functional style, too. Just as important, they are
careful in what they omit, thus leaving room for one of Scala’s most powerful
features, the function literal, which will be described in the next chapter.
*/