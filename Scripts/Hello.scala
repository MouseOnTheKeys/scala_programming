println("Hello Scala... From a Script !!!")
println("Hello " + args(0) + ", also from a script")

var i = 1 //variable definition, type inference gives the i  the type scala.Int
while (i < args.length) { // args.length gives the length of the args array
    println(args(i)) // print out the each ith command line argument
    i += 1 // ++i and i++ does not work in Scala
}

// pass into the terminal : scala Hello.scala Nenad Scala is Fun to code and work

