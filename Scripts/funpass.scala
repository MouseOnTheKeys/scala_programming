/*
One of the main carachter of functional language is that functions are first class constructs
Functional Style of programming
We call the foreach method on args and pass it into the a function
In this case we are passing the function literalthat takes one parameter named arg.

paste In terminal : scala funpass.scala Concise is nice
*/

args.foreach(arg => println(arg))

/*
Scala interpreter infers the type of argument to be a String, since the string is the element of array on wich you  are calling foreach
More explicit way we can do something like this, but we need to wrrap the argumentportion in parentheses (which is the normal form of sintax anyway)
*/

args.foreach((arg: String) => println(arg))

/*
Shorthand, partially applied function
*/
args.foreach(println)


//Only a functional relativeof the imperative "for" (called a for expresson) is available in Scala

for (arg <- args) //read as for arg in args
    println(arg)
/*
The parentheses after "for" contain arg <- args. To the right of the <- symbol is the familiar args array. To the left of <- symbol is
arg the name of a val, not var. (Because it is always a val, you just write arg by itself not "val arg"). Although arg may sem to be a var
because it will get a new value on each iteration, it really is a val: arg cant be reassigned inside a body of the expresion . Instead, for
each element of the array a new arg val is created and initialized to the element value and the body of the for will be executed.
*/