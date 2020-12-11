### Week 4

#### Lecture 4.1

Pure Object Orientation

A pure object oriented language is one in wich every value is an object.

If the language is bsed on classes this means that the type of each value is a class.

Standard Classes

Conceptualy, types such as Int and Boolean do not receive a special treatment in Scala. They are like the other classes defined in the package Scala.

For reason of efficiency, the Scala compiler represent the values of type scala.Boolean by Java`s Booleans, etc.

The Boolean type maps to JVM primitive type boolean.

But one _could_ define it as a class from first principles:

```Scala
package idealized.scala
abstract class Boolean {
    def ifThenElse[T](t: => T, e: => T): T
    def && (x: => Booolean): Boolean = ifThenElse(x, false)
    def || (x: => Boolean): Bolean = ifThenElse(true, x)
    def unary_!: Boolean    = ifThenElse(false, true)

    def == (x: Boolean): Boolean = ifThenElse(x, x.unary_!)
    def !+ (x: Boolean): Boolean = ifThenElse(x.unary_!,x)
    ...
}
```

Boolean constants

Here are constants true and false that go with Boolean in the idealized.scala:

```Scala
package idealized.scala

object true exdends Boolean {
    def ifThenElse[T](t: => T,e: => T) = t
}
object false extends Boolean {
    def ifThenElse[T](t: => T. e: => T) = e
}
```

THE CLASS INT

Here is the partial specification of the class scala.Int:

````Scala
class Int{
    def + (that: Double): Double
    def + (that: Float): Float
    def + (that: Long): Long
    def + (that: Int): Int // same for -,*,/,%

    def << (cnt: Int): Int // same for >>, >>>, */

    def & (that: Long): Long
    def & (that: Int): Int // same for |, ^ */

    def == (that: Double): Boolean
    def == (that: Float): Boolean
    def == (that: Long): Boolean // same for !=,<,>,<=,>=
    ```
}
````

Exercise:

Provide an implementation of the abstract class Nat (Natural Numbers) that represent non-negative integers:

```Scala
abstract class Nat {
    def isZero: Boolean
    def predecessor: Nat
    def successor: Nat
    def + (that: Nat): Nat
    def - (that: Nat): Nat
}
```

Do not use standart numerical classes in this implementation .
Rather, implement a sub-object and a sub class:

```Scala
object Zero extends Nat{
    class Succ(n: Nat) extends Nat
}
```

One for the number zero, the other for strictly positive numbers.
(this one is a bit more involved than previous quizzes)
