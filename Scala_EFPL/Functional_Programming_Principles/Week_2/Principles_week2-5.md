### Week 2

#### Lecture 2.5

**Functions And Data**

In this section we`ll learn how functions create and encapsulate data structures.

**Rational Numbers**
We want to design a package for doing rational arithmetic.
A rational number $x/y$ is represented by two integers.
* its numerator x and
* its denominator y.

Suppose we want to implement the addition of two rational numbers.
```Scala
def addRationalNumerator(n1: Int. d1: Int, n2: Int, d2: Int): Int
def addRationalDenominator(n1: Int, d1: Int, n2: Int, d2: Int): Int
```
but it would be difficult to combine all these numerator and denominators.
A better chice is to combine the numerator and denominator of a rational numberin a data structure.

In Scala we do this by defining a class:
```Scala
class Rational(x: Int, y: Int) {
    def numer = x
    def denom = y
}
```
This definition introduces two entities:
* A new type named rational.
* A constructor Rational to create elements of this type.

Scala keeps the names of types and values in different namespaces.
Sp there's no conflict between the two definitions of Rational.

**Objects**

We call the elements of a class type **objects**.
We create an object by prefixing an application of the constructor of the class with the operator new.
`new Rational(1,2)`

A type in a programming language is essentially a set of values.
Now, the values that belong to a class type are called objects.

Objects of class Rational have now two members, numer and denom.
We select the members of an object with the infix operator '.' (like in Java)

Implementing Rational Arithmetic

```Scala
def addRational(r: Rational, s:Rational): Rational =
    new Rational(
        r.numer * s.denom + s.numer *r.denom, r.denom * s.denom)
def makeString(r: Rational) =
r.numer + "/" + r.denom

makeString(addRational(new Rational(1,2),new Rational(2,3)))
```
One can go further and also package functions operating on a data abstraction itself.
Such functions are called methods.

Rational numbers now would have in addition to the functions numer i denom, the functions add, sub, mul, div, equal, toString.

***Excercise***

1. In worsheet add a method neg to class Rational that is used like this
x.neg //evaluates to -x
2. Add a method sub to substract two rational numbers.
3. With the values x,y,z as given in the previous slide, what is the result of x - y-z ???

