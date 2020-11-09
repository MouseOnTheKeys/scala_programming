// TUPLES
/*
Like Lists, Tyuples are immutable, but umlike lists tuples can contain different elements.
To instantiate a new tuple that holds some objects just place the objects in prentheses separated by commas.
Once the tuple is instantiated, we can access its elementsindicidually with dot(.), underscore(_), and the 0ne-Based indexof the element.
*/
val pair = (99, "Luftaballons")
println(pair._1)
println(pair._2)
/*
we can`t access the elements in tuples like the elements in lists, with " pair(0) ". The reason is that a lists apply method always return the same type.
but each of the tuple may be different type: _1 can be one type result,_2 the other and so on. These _N numbers are one-based instead of zero-based.
*/
// Creating a SET
var jetSet = Set("Boeing", "AirBus") // invoking a factory nethod name apply on Set companion object, wich returns an instance of a default, Immutable Set.
jetSet += "Bombardier" // on both immutable and mutable sets, the (+) method will create and return a new set with the element added.
jetSet = jetSet + "Lear" // same as above line
println(jetSet.contains("Cessna")) // returns false
//Creating, Initializing and using a immutable Set.

//If we want Mutable Sset , we have to use import.
import scala.collection.mutable

val movieSet = mutable.Set("The Witcher","Poltergeist","The Dark") // Because this is mutable Set no need to reassign, it can be val on contrary to immutable SET where it must be var
movieSet += "Shrek"
movieSet.+=("Shark III") // same line as above.
println(movieSet)
/*
Import allows us to use shorter name Set instead to type longer , fully qualified name. Although the default set implementations produced by the mutable
and immutable Set factory will likly be sufficiantfor most situations, occsionally you may want an explicit set class. Syntax is similar. Simply importclass we need
and use the factory method on comapainion object
*/
// Example Immutable HashSet
import scala.collection.immutable.HashSet

val hashSet = HashSet("Tomatoes", "Chilies")
println(hashSet + "Coriander")

// not possible hashSet += "Onions"
println(hashSet)

// Another usefull collection class in Scala is MAP
// Scala provides mutable and immutaable versions of Map
import scala.collection.mutable // we import the mutable Map

val treasureMap = mutable.Map[int,String]() // we define a val named treasureMap and initaialize it with an empty mutable Map that has Int and String values.
treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find X on the ground.")
treasureMap += (3 -> "Dig.") // THIS -> method which you can invoke on any object in Scala program returns a two-element tuplecontaining the key and the value
treasureMap += (4 -> "Dig more.")
println(treasureMap(2))
/* The explicit type of parameterization "[Int, String]" are requiredbecause without it any values passed to the factory method, the compailer can infer the type parameters.
*/
// Immutable Map - no import is necessary
val romanNumeral = Map(
    1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
)
println(romanNumeral(4))
// Given there are no imports when we say "Map" in the firs line we wil get the default: NOTE import scala.collection.immutable.Map

// ANCHOR Functional Style of programing - try using val instead of var
def printArgs(argd: Array[String]): Unit = {
    var i = 0
    while (i <args.length){
        print(args(i))
        i += 1
    }
}
// lets transfor it into more functional approach
def printArgs(args: Array[String]): Unit = {
    dor (arg <- args)
    println(arg)
}
// or THIS
def printArgs(args: Array[String]): Unit = {
    args.foreach(println)
}
// More than THIS
def formatArgs(args: Array[String]) = args.mkString("\n")

val res = formatArgs(Array("zero", "one","two"))
assert(res == "zero\none\ntwo") //Scala`s assert method checks the passed Boolean if it is false, throws AssertionError if it is true it returns quietly.
println(res)