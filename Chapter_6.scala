// FUNCTIONAL OBJECTS

// Rational
val oneHalf = new Rational(1,2)
val twoThirds = new Rational(2,3)

class Rational(n: Int, d: Int) {
    println("Created " + n + "/" + d)
}

// In Scala classes can take parameters directly in the body of the class
class Rational(n: Int, d: Int) {
    override def toString = n + "/" + d
} //The override modifier in front of a method definition signals that a previous method definition is overridden

val x = new Rational(1, 3)
/*
One of the benefits of object-oriented programming is that it allows you
to encapsulate data inside objects so that you can ensure the data is valid
throughout its lifetime. In the case of an immutable object such as Rational,
this means that you should ensure the data is valid when the object is constructed.
 */
class Rational(n: Int, d: Int) {
    require(d != 0)
    override def toString = n + "/" + d
}

val x = new Rational(2,0) // class Rational(n: Int, d: Int) {
/*
The require method takes one boolean parameter. If the passed value is
true, require will return normally.
*/

clss Rational(n: Int, d: Int) {
    require(d != 0)
    override def toString( n + "/" + d)
    def add(that: Rational): Rational =
        new Rational(n * that.d + that.n * d, d * that.d)
} // WILL NOT COMCOMPILE

val x = new Rational(5,7)
x.add(x)

class Rational(n: Int, d: Int) {
    require(d != 0)
    val numer: Int = n
    val denom: Int = d
    override def toString = numer + "/" + denom
    def add(that: Rational): Rational =
        new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
        )

    def lessThan(that: Rational) =
        this.numer * that.denom < that.numer * this.denom // method which tests whether the given Rational is smaller than a parameter

    def max(that: Rational) =
        if (this.lessThan(that)) that else this

}
val oneHalf = new Rational(1, 2)
val twoThirds = new Rational(2, 3)
oneHalf add twoThirds // res0: Rational = 7/6

val r = new Rational(12, 55)
r.numer
r.denom

def lessThan(that: Rational) =
    this.numer * that.denom < that.numer * this.denom // method which tests whether the given Rational is smaller than a parameter

def max(that: Rational) =
    if (this.lessThan(that)) that else this
/*
Here, this.numer refers to the numerator of the object on which lessThan
was invoked. You can also leave off the this prefix and write just numer ;
the two notations are equivalent.
*/
def max(that: Rational) =
    if (this.lessThan(that)) that else this

/*
To normalize the result we need to divide the numerator and denominator
by their greatest common divisor.
*/
class Rational(n: Int, d: Int) {
    require(d != 0)
    private val g = gcd(n.abs, d.abs)
    val numer = n / g
    val denom = d / g
    def this(n: Int) = this(n, 1)

    def add(that: Rational): Rational =
        new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
        )
    override def toString = numer + "/" + denom

    private def gcd(a: Int, b: Int): Int =
        if (b == 0) a else gcd(b, a % b)
}

new Rational(66, 42) // res5: Rational = 11/7

/*
The first step is to replace add by the usual mathematical symbol. This
is straightforward, as + is a legal identifier in Scala.
We can simply define a method with + as its name.
 */
class Rational(n: Int, d: Int) {
    require(d != 0)
    private val g = gcd(n.abs, d.abs)
    val numer = n / g
    val denom = d / g

    def this(n: Int) = this(n, 1)

    def + (that: Rational): Rational =
        new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
    )
    def * (that: Rational): Rational =
        new Rational(numer * that.numer, denom * that.denom)

    override def toString = numer + "/" + denom

    private def gcd(a: Int, b: Int): Int =
        if (b == 0) a else gcd(b, a % b)
}
val x = new Rational(1, 2)
val y = new Rational(3, 4)

x + y //res0: Rational = 5/4 same as x.(+)y

x + x * y // res0: Rational = 5/4

/*
But one thing still missing is mixed arithmetic. We cannot multyply a rational number by integer
because that is not defined in our abstraction, yet
To make Rational even more convenient, we’ll add new methods to the
class that perform mixed addition and multiplication on rational numbers and
integers.
*/

class Rational(n: Int, d: Int) {
    require(d != 0)
    private val g = gcd(n.abs, d.abs)
    val numer = n / g
    val denom = d / g

    def this(n: Int) = this(n, 1)

    def + (that: Rational): Rational =
        new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
        )

    def + (i: Int): Rational =
        new Rational(numer + i * denom, denom)

    def - (that: Rational): Rational =
        new Rational(
        numer * that.denom - that.numer * denom,
        denom * that.denom
        )

    def - (i: Int): Rational =
        new Rational(numer - i * denom, denom)

    def * (that: Rational): Rational =
        new Rational(numer * that.numer, denom * that.denom)

    def * (i: Int): Rational =
        new Rational(numer * i, denom)

    def / (that: Rational): Rational =
        new Rational(numer * that.denom, denom * that.numer)

    def / (i: Int): Rational =
        new Rational(numer, denom * i)

    override def toString = numer + "/" + denom

    private def gcd(a: Int, b: Int): Int =
        if (b == 0) a else gcd(b, a % b)
} //Now that you can write r * 2 , you might also want to swap the operands, as in 2 * r . Unfortunately this does not work yet:

val r = new Rational(2,3)
2 * r
/*
However, there is another way to solve this problem in Scala: You can
create an implicit conversion that automatically converts integers to rational
numbers when needed. Try adding this line in the interpreter:
*/
implicit def intToRational(x: Int) = new Rational(x) // This defines a conversion method from Int to Rational.

val r = new Rational(2,3)
2 * r

/*
For an implicit conversion to work, it needs to be in scope. If you place the
implicit method definition inside class Rational , it won’t be in scope in the
interpreter.
*/