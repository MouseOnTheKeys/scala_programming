### Week 3

#### Lecture 3.2

Packages

Classes and objects are organized in packages.
To place a class or object inside a package clause at the top of your  source file
```Scala
package progfun.examples

object Hello{
    ...
}
```
This would place Hello package progfun.examples.
You can than refer place hello  by its fully qualified name progfun.examples.Hello. For instance to run the Hello program:
`> scala progfun.examples.Hello`

**Forms of Importts**
Imports come in several forms:
```Scala
import week3.Rational   // import just Rational
import week3.{Rational, Hello}  // import both Rational and Hello
import week3._  // import everything from package week3
```
The first two forms are called named imports.
The last is called wildcard import.
You can import from either a package or an object.

Automatic imports

Some entities are imported in any Scala program.
These are:
- All members of package Scala
- All members of package java.lang
- All members of the singleton object scala.Predef

Here are the fully cualitied names of some types and functions which we have seen so far:
```
Int      |   scala.Int
Boolean  |   scala.Boolean
Object   |   java.loang.Object
require  |   scala.Predef.require
assert   |   scala.Predef.assert
```

**Traits**
In Java as well as in Scala a class can only have one superclass. (Single inheritance language)
But what if a class has several natural supertypes to which it conforms or from which it wants to inherit code?

Here, we can use traits.

A trait is declared like an abstract class, just with trait instead of abstrct class.
```Scala
trait Planar {
    def height: Int
    def width: Int
    def surface = height * width
}
```
Classes, objects and traits can inherit from at most one class but arbitrary many traits.
Example:
```Scala
class Square extends Shape with Planar with Movable ...
```
Traits resemble interfaces in Java, but are more poerfull because they can contains fields and concrete methods.

On other hand, traits cannot have(value) parameters, only classes can.

Top Types

Any - the base type of all types - Methods: '==', '!=', 'hashCode','toString'

AnyRef - The base type od all reference type: Alisa of 'java.lang.Object'

AnyVal - The base of all primitive type

**The nothing type **
Nothingis at the bottom of all Scala type hierarchy. It is a subtype of every other type.

There is no value of type Nothing.

Why is this udful ?
- To signal abnormal termination
- As an element type of empty collection

**Exceptions**

Scala's exception handling is ismilar to Java's
Theexception:
`throw Exc`
aborts evaluation with the exception Exc.

**The Null Type**

Every referance value type also have the null as a value.
The type of null is Null.
Null is a subtyoe of every calss that inherits from Object; it is incompatble with subtype of AnyVal.
```Scala
val x = null // x: Null
val y: String = null // y: String
val z: Int = null // error type mismatch
```
