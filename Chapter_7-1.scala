/*
Scala’s if works just like in many other languages. It tests a condition and
then executes one of two code branches depending on whether the condition
holds true. Here is a common example, written in an imperative style:
*/
var filename = "default.txt"
if (!args.isEmpty)
    filename = args(0)

val filename =
    if (!args.isEmpty) args(0)
    else "default.txt"

/* This code is slightly shorter, but its real advantage is
that it uses a val instead of a var . Using a val is the functional style, and it
helps you in much the same way as a final variable in Java.
A second advantage to using a val instead of a var is that it better supports equational reasoning.
*/

println(if (!args.isEmpty) args(0) else "default.txt")

// Using val s helps you safely make this kind of refactoring as your code evolves over time.

// Scala's while loops behaves as in other languages. It has a condition and a body, and the body is executed over and over as long condition is true.

def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
        val temp = a
        a =b % a
        b = temp
    }
    b
}
// Scala also has a do - while loop. This works like the while loop except that it tests the condition after the loop body instead of before.
var line = ""
do {
    line = readLine()
    println("Read: " + line)
} while (line != "")
/*
The while and do-while constructs are called “loops,” not expressions,
because they don’t result in an interesting value. The type of the result is
Unit . It turns out that a value (and in fact, only one value) exists whose type
is Unit . It is called the unit value and is written () . The existence of () is
how Scala’s Unit differs from Java’s void .
 */
def greet() = { println("Hi, Scala !!!")}
() == greet()
greet()
/*
Because no equals sign precedes its body, greet is defined to be a proce-
dure with a result type of Unit . Therefore, greet returns the unit value, () .
This is confirmed in the next line: comparing the greet ’s result for equality
with the unit value, () , yields true .
*/
var line = ""
while ((line = readLine()) != "") // This doesn't work!
    println("Read: " + line)
/*
When you compile this code, Scala will give you a warning that comparing
values of type Unit and String using != will always yield true. Whereas
in Java, assignment results in the value assigned (in this case a line from
he standard input), in Scala assignment always results in the unit value, () .
Thus, the value of the assignment “ line = readLine() ” will always be ()
and never be "" . As a result, this while loop’s condition will never be false,
and the loop will, therefore, never terminate.
*/
def gcd(x: Long, y: Long): Long =
    if (y == 0) x else gcd(y, x % y)

/*
In general, we recommend you challenge while loops in your code in the
same way you challenge var s. In fact, while loops and var s often go hand
in hand. Because while loops don’t result in a value, to make any kind of
difference to your program, a while loop will usually either need to update
var s or perform I/O.
*/

// FOR EXPRESSION

// Iteration throgh collection

var fileHere = (new java.io.File(".")).listFiles
for (file <- filesHere)
    println(file)

/*
With the “ file <- filesHere ” syntax, which is called a generator, we
iterate through the elements of filesHere . In each iteration, a new val
named file is initialized with an element value. The compiler infers the
type of file to be File , because filesHere is an Array[File] . For each
iteration, the body of the for expression, println(file) , will be executed.
Because File ’s toString method yields the name of the file or directory, the
names of all the files and directories in the current directory will be printed.
*/
for (i <- 1 to 5)
    println("Iteration " + i)
// If you don’t want to include the upper bound of the range in the values that
// are iterated over, use until instead of to :
for (i <- 1 until 5)
    println("Iteration " + i)

// Not common in Scala...
for (i <- 0 to filesHere.length - 1)
    println(filesHere(i))

/*
The reason this kind of iteration is less common in Scala is that you can
just iterate over the collection directly. When you do, your code becomes
shorter and you sidestep many of the off-by-one errors that can arise when
iterating through arrays. Should you start at 0 or 1? Should you add -1, +1,
or nothing to the final index? Such questions are easily answered, but also
easily answered wrong. It is safer to avoid such questions entirely.
*/

// FILTERING

/*
Sometimes you don’t want to iterate through a collection in its entirety; you
want to filter it down to some subset. You can do this with a for expression
by adding a filter, an if clause inside the for ’s parentheses.
*/
val filesHere = (new java.io.File(".")).listFiles
for (file <- filesHere if file.getName.endsWith(".scala"))
    println(file)

// we also can write

for (file <- filesHere)
    if (file.getName.endsWith(".scala"))
        println(file)

// we can include more filters if you want. Just keep adding if clauses. For example, to be extra defensive,

for (
    file <- filesHere
    if file.isFile
    if file.getName.endsWith(".scala")
) println(file)

// NESTED ITERATION

// If you add multiple <- clauses, you will get nested “loops.”
// The outer loop iterates through filesHere , and the inner loop iterates through fileLines(file) for any file that ends with .scala .

def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toList
def grep(pattern: String) =
    for (
        file <- filesHere
        if file.getName.endsWith(".scala");
        line <- fileLines(file)
        if line.trim.matches(pattern)
    ) println(file + ": " + line.trim)
grep(".*gcd.*")

