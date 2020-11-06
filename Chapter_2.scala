val msg = "Hello, World!!!"
println(msg)

val msg2: java.lang.String = "HelloWorld, agian!"

val msg3: String = "Hello World, yet once again"

msg = "Not able to reassign" // not posiblle to rassingned tha val variable only var !!!

var greeting = "Hello Scala !!!"

greeting = "Hello Python & Scala !!!" // now it is posible to reassign the variable cause we used var !!!
println(greeting)

//to span multiple lines we use | to typr or print in next line
val multiLine = """This is
|not what
|I had in mind"""

// Defining some functions
def max(x: Int, y: Int): Int = { //"def" stats defining function, parameter list x and y with type definition, last Int is result type
    if (x > y) x
    else y
} // curly brace contain the body of the function

def min(x: Int, y: Int) = if (x < y) x else y //If function consist of just one statment , we can optionally leave of a curly braces

max(res4,7)

//Function that take no parameter and returns no interesting result
def greet() = println("Hello people of the third world counties !!!") // result type of Unit indicates that finction returns no interesting value
greet()
// every void returning method in Java is mapped to a Unit-returning method in Scala. Methodd with the result type of Unit are only executed for its side effect
// in this example side effect is greet msg printed in standard output.


