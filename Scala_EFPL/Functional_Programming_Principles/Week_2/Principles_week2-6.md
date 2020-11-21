### Week 2

#### Ledcture 2.6

***Data Abstraction***

The previous example has shown that rational numbers aren't always represented in their simplest form(Why?)
One would expect the rational number to be simplified:
* reduce them to their smallest numerator by dividing with a dvisor.

We could implement  this in  each rational operation, but it would be easy to forget thi division in an operation.
A better alternative consist of simplifying the representation in the class when the objects are constructed:
```Scala
class Rational(x: Int, y: Int) {
    private def gcd(a: Int, b: Int): Int = if (b==0) a else gcd(b, a % b) // method of class rationasl  it is PRIVATE strictly for implementation purposes
    private val g = gcd(x, y)
    def numer = x / g
    def denom = y / g
...
}
```
gcd and g are ***private*** members of class Rational, and we can access them from inside the Rational class.

In this example, we calculate gcd immediately, so that its value can be re-used in the calculations of numer and denom.

> Client observe exactly the same behavoir in each class.
> This ability to choose different implementation of the data without affecting clients is called ***data abstraction***.
> It is a cornerstone of software engineering.

On the inside of a class, the name ***this*** represents the object on wich the current method is executed.

Add the functions less and max to the class Rational.
```Scala
class Rational(x: Int, y: Int) {
    ...
    def less(that: Rational) = numer * that.denom < that.numer *denom

    def max(that: Rational) = if (this.less(that)) that else this // this is known also as self in OO Programming laguages (Python)
}
```
Note that simple name $x$, which refers to another member of the class, is an abbrevation of ***this.x***. Thus, an equvalent wat to formulate less is as follows:
```Scala
def less(that: Rational) =
    this.numer * that.denom < that.numer * this.denom)
```
***Preconditions***

Let's say our Rational class requires that the denominator is positive.
We can enforce this by calling the require function.
```Scala
class Ratuinal(x: Int, y:Int) {
    require(y > 0, "denominator must be positive")
    ...
}
```
***require*** is predefined function.
It takes a confition and an optional string.
If the condition is passed to a require is false, an ***illegalArgumentExcepton*** is thrown with the given message string.

Beside, require there is also another test wich is called ***assert***.
Assert also takes a condition and an optinal massage as parameters.
```Scala
val x = sqrt(y)
assert(x >= 0)
```
Like require, a failling assert will also throw an exception, but it's a different one: `AssertionError` for assert, `IllegalArgumentEcepton` for require.
This reflects a difference in intent
* require is used to enforce a precondition on the caller of a function.
* assert is used as  to check the code of the function itself.

In Scala a class implicitly introducec a constructor. This one is called the ***primary constructor*** of the class.

The primary constructor:
- takes the parameters of the class
- and execute all statments  in the class body (such as the require a couple of slide back).

