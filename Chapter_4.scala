// CLASSES AND OBJECTS

/*
Once we define the class we can create objects fromthe class blueprint with the keyword new.
Inside the class definiton we place fields for methods, wich are collectively called members.
Fields, wich we define either val or var are variables that reger to objects.
Methods wich we define with "def" contain executable code.
The fields holds the state, or data of an object, wheres the methods use data to do the computatioonal work of the object.
*/
class ChecksumAccumulator {
    //class definition ...
    var sum = 0
}
//we instantiate the class with
val acc = new ChecksumAccumulator
val csa = new ChecksumAccumulator
// Since sum, a field declared inside of the class ChecksumAccumulator is a var, not a val we can later reassign to sum a different Int value like this:
acc.sum = 3 // we were able to mutate the object acc refered to even though acc is val. What we cant do is with acc or csa is reassign a different object to them.
// Fields are also known as instance variables, because every instance gets its own set of variables.
acc = new ChecksumAccumulator // will fail if compiled
/*
acc will always refer to the same ChecksumAccumulator object with which we initiaize it, but fiels inside that object can be changed over time.
One important way to pursue robustness of an object is to ensure that the object`s state - values of its instance variables - remains valid during its entire liftime.
The first step is to prevent the outsiders from accesing fields directly by making the fields private.
Private fields can only be accessed by methods defined in some class, all the code that can update the state will be localized to the class.
to declre the field private we do this :
*/
class ChecksumAccumulator {
    private var sum = 0
}
// anu attempt to access sum from outside will fail
val acc = new ChecksumAccumulator
acc.sum = 5
// in Scala is default acces level

/*
Now that sum is private the only code that can access sum is code defined inside the body of the class itself
we will now define some methods in it
*/
class ChecksumAccumulator {
    private var sum = 0
    def add(b: Byte): Unit {
        sum += b
    }
    def checksum(): Int = {
        return ~(sum & 0xFF) + 1
    }
}
/*
Now class ChecksumAccumulator has 2 methods, add and checksum.
Any parameters to the method can be used inside the method. One important characheristics of method parameters in Scala is that they are vals not vars.
If you try to reassign a paremeter inside the method in scala it will fail to compile.
*/
def add(b: Byte): Unit = {
    b = 1 //this won`t compile because the b is val
    sum += b
}
/*
The return at the end of the checksum method is superfluous and can be dropped. In the absence of any explicit return statment the Scala method returns the
last value computed by method. The recomended style for methods is in fact to avoid having explicit, and esspecially multipe return statements.
Think of each method as an expression tha yields one value, which is returned.
 */
class ChecksumAccumulator {
    private var sum = 0
    def add(b: Byte): Unit = { sum += b }
    def checksum(): Int = ~(sum & 0xFF) + 1
}
// An add`s case the side effect is that sum is reassigned. A method that is executed only for its side effects are known as a procedure.

// SINGLETON OBJECTS

/*
When a singleton object share the same name witha class, its called class`s companion object.
We must deffine both the class and its companion object in the same source file.
The class is called the companion class of the singleton object.
Aclass and its companion objects can access each other`s private members
 */
/*
The ChecksumAccumulator singleton object has one methodnamed calculate, wich takes the single string and calculates a checksum for charachters in the string.
It also hs one private field cache, a mutable map im wich previusly calculated checksums are cached.
*/
// in file ChecksumAccumulator.scala
import scala.collection.mutable

object ChecksumAccumulator {
    private val cache = mutable.Map.empty[String, Int]

    def calculate(s: String): Int =
    if (cache.comtains(s)) // checks the cache to see, if the passed string is already contained as a key in map.
        cache(s) // if so returns String from cache or ..
    else {
        val acc = new ChecksumAccumulator //
        for (c <- s)
            acc.add(c.toByte)
        val cs = acc.checksum()
        cache += (s -> cs)
        cs
    }
}
