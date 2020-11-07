// In Scala instantiate class instances or object using new
val big = new java.math.BigInteger("12345678")
// Praameterization means "configuring" an instace when creating it.
// We parameterizing an instace with types by specifying one or morte types in square brackets.
val greetString = new Array[String](3)
// more expliscit way : val greetString: Array[String] = new Array[String](3);]
greetString(0) = "Hello"
greetString(1) = ", "
greetString(2) = "Scala !\n"

for (i <- 0 to 2)
    print(greetString(i))

greetString(2) = "World !\n"

for (i <- 0 to 2)
    print(greetString(i))

/*
greetString is a value of type Array[String] ("array of string") that inirialized to length 3 by parameterizing it with value 3 in the first line of code
If we run it as a Script we will get "Hello, Scala !"
*/

/*
when an assignament is made to a variable to wich parentheses and one or more arguments have been applied, the compiler will transform that into an invocaton of an
update method that takes the arguments in parentheses as well as the object to the right of the sign equals.
*/
greetString(0) = "Hello" //is same as
greetString.update(0,"Hello")

// followwing semanticaly to the previous code:
val greetString = new Array[String](3)
greetString.update(0, "Hello")
greetString.update(1, ", ")
greetString.update(2, "Scala !\n")

for (i <- 0.to(2))
    print(greetString.apply(i))
// Normal use of cration of array:
val numNames = Array("zero", "one", "two")
// acctually we are calling the factor method named apply which creates and returns the new array
// This apply method is takes a variable number of arguments and is defined on the Array companion object***
val numNames2 = Array.apply("zero", "one","two")
/*
Although we cant change the length of array after it is instantiated we can change its element values. Arrays are mutable objects.
For immutable sequence of objectgs that share the same type we can use Scala`s List class.
Scala`s List is designed to to enable more functional style of programming
*/
val oneTwoThree = List(1,2,3)
// when we call a method on the list that might seem by its name to imply the list will mutate,it instead create and returns a new listwith new value.
// List has a method " ::: " - for list concatination
val oneTwo = List(1,2)
val threeFour = List(3,4)
val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo + " and " +threeFour + " were not mutated." )
println("thus, " + oneTwoThreeFour + " is the new list.")
/*
The most common operator we use with list is " :: " which is pronaunces "cons".
Cons prepends a new element to rhe beginning of the list and returns the resulting list.
*/
val twoThree = List(2,3)
val oneTwoThree = 1 :: twoThree
println(oneTwoThree)
// shorthand way to specify the empty list is " Nil "
val oneTwoThree = 1 :: 2 :: 3 :: Nil
println(oneTwoThree)
oneTwoThree.length // length of list
oneTwoThree(2) // returns the element t the index 2 (zero based) result 3
oneTwoThree.drop(2) // returns the list without the first two elements
oneTwoThree.dropRight(1) // return the list without its rightmost element
oneTwoThree.foreach(s=>print(s)) // executes the print statment on each element (prints 123 )
oneTwoThree.last // returns the last element of the list
oneTwoThree.init // returns a list of all but the last elementin list
oneTwoThree.map(i=>i + "s") // returns the list resulting from adding "s" to each element of the list (returns 1s, 2s, 3s)
oneTwoThree.isEmpty // indicates whether the list is empty (false)
oneTwoThree.head // returns the first element of the list
oneTwoThree.tail // returns the last element of the list
oneTwoThree.mkString(", ") // making string with elements of the list (returns 1, 2, 3)
oneTwoThree.reverse // returns all elements of the list in reverse order