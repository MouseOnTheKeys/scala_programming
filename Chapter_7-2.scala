// MID-STREAM VARIABLE BINDINGS

def grep(pattern: String) =
    for {
    file <- filesHere
    if file.getName.endsWith(".scala")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
} println(file + ": " + trimmed)
grep(".*gcd.*")

//producing a new collection

/*
While all of the examples so far have operated on the iterated values and then
forgotten them, you can also generate a value to remember for each iteration.
To do so, you prefix the body of the for expression by the keyword yield .
For example, here is a function that identifies the .scala files and stores
them in an array
*/

def scalaFiles =
    for {
            file <- filesHere
            if file.getName.endsWith(".scala")
    } yield file

/*
Each time the body of the for expression executes, it produces one value,
in this case simply file . When the for expression completes, the result
will include all of the yielded values contained in a single collection. The
type of the resulting collection is based on the kind of collections processed
in the iteration clauses. In this case the result is an Array[File] , because
filesHere is an array and the type of the yielded expression is File .
*/

// The syntax of a for - yield expression is like this

for clauses yield body

/*
The yield goes before the entire body. Even if the body is a block surrounded by curly braces,
put the yield before the first curly brace, not be fore the last expression of the block. Avoid the temptation to write things
like this */

for (file <- filesHere if file.getName.endsWith(".scala")) {
yield file // Syntax error!
}

// Transforming an Array[File] to Array[Int] with a for .
val forLineLengths =
for {
file <- filesHere
if file.getName.endsWith(".scala")
line <- fileLines(file)
trimmed = line.trim
if trimmed.matches(".*for.*")
} yield trimmed.length

// EXCEPTIONS HANDLING WITH TRY EXPRESSIONS

/* Scala’s exceptions behave just like in many other languages. Instead of re-
turning a value in the normal way, a method can terminate by throwing an
exception. The method’s caller can either catch and handle that exception,
or it can itself simply terminate, in which case the exception propagates to
the caller’s caller.
*/

//throw exceptions

throw new IllegalArgumentException

//Throwing an exception in Scala looks the same as in Java.

val half =
    if (n % 2 == 0)
        n / 2
    else
        throw new RuntimeException("n must be even")

// CATCHING EXCEPTIONS

//The syntax for catch clauses was chosen for its consistency with an important part of Scala pattern matching.

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

try {
    val f = new FileReader("input.txt")
    // Use and close file
} catch {
    case ex: FileNotFoundException => // Handle missing file
    case ex: IOException => // Handle other I/O error
}

/* The behavior of this try - catch expression is the same as in other languages
with exceptions. The body is executed, and if it throws an exception,
each catch clause is tried in turn. In this example, if the exception is of
type FileNotFoundException , the first clause will execute. If it is of type
IOException , the second clause will execute. If the exception is of neither
type, the try - catch will terminate and the exception will propagate further.
*/

//YIELDING A VALUE

/*
If an exception is thrown but not caught, the
expression has no result at all. The value computed in the finally clause, if
there is one, is dropped. Usually finally clauses do some kind of clean up,
such as closing a file. Normally, they should not change the value computed
in the main body or a catch clause of the try .
 */
def f(): Int = try return 1 finally return 2

// A catch clause that yields a value.

import java.net.URL
import java.net.MalformedURLException

def urlFor(path: String) =
    try {
        new URL(path)
    } catch {
        case e: MalformedURLException =>
        new URL("http://www.scala-lang.org")
    }

// calling f() results in 2. By contrast, given:

def g(): Int = try 1 finally 2

//The best way to think of finally clauses is as a way to ensure some side effect happens, such as closing an open file.
