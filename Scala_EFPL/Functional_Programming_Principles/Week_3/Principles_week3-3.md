### Week 3

#### Lecture 3.3

**_Polymorphism_**

A fundamental data structure in many functional languages is the immutable linked list.

It is constructed from two blocks:

```
Nill    |   the empty list
Cons    |   a cell contain an element an element and the remainder of the list.
```

Examples :
`List(1,2,3)`

```
|_|_|
/   \
1   |_|_|
    /   \
    2   |_|_|
        /   \
        3   Nil
```

`List(List(true,false), List(3)`

```
          |_|_|
        /      \
    |_|_|       |_|_| - Nil
    /   \       \
true    |_|_|   |_|_|
        /   \    \   \
    false   Nil   3   Nil
```

**Cons-List in Scala**

Here's an outline of a class hierarchy that represent lists of integers in this fasshion:

```Scala
package week 4
trait  intList ...
class Cons(val head: Int, val tail: IntList) extends IntList ... // val head: Int - define in the same time a parameter  and field deffinition
class Nil extends IntList ...
```

A list is either:

- an empty list new Nil, or
- a list new Cons(x, xs) consisting of a head element x and a tail list xs

**Value Parameters**
Note the abbrevation (val head: Int, val tail: Int) in teh definition of Cons.
This defines at the sasme time parameters an fields of a class.
It is equivalent to:

```Scala
class Cons(_head: Int, _tail: IntList) extends IntList {
    val head = _head
    val tail = _tail
}
```

where \_head and \_tail are otherwise unused names.

**Type Parameter**

It seems too anrow to define only lists with Int elements.
We'd need another class hierarchy fot Double lists and so on, one for each possible element type.

We can generalize the definition using a type parameter:

```Scala
package week4

trait List[T]
class Cons[T](val head: T, val tail: List[T]) extends List[T]
class Nil[T] extends List[T]
```

Type parameters are written in square brackerts, e.g. [T].

**Generic Functions**

Like classes, functions can have type parameters.

For Istance, here is a function that creates a list consisting of a single element.

```Scala
def singleton[T](elem: T) = new Const[T](elem, new Nil[T])
```

We can write:

```Scala
singleton[Int](1)
singleton[Boolean](true)
```

In fact, the Scala compiler can usually deduce the correct type parameters from the value arguments of a function call.
So, in most cases, type parameters can be left out. You could also write:

```Scala
singleton(1)
singleton(true)
```

**Types and Evaluation**

Type parameters do not affect evaluation in Scala
We can assume that type parameters and typr arguments are removed before evaluating the program.
This is also called type erasure.
Languages that use type erasure include Java, Scala Haskel , ML
Some other languages keep the type parameters around at run time, these include C++, C# , F#.

Polymorphism means that a function types comes "In many different forms".

In programming it means that

- the function can be applied to arguments of many types, or
- the type can be instance of many types.

We have seen two principal forms of polymorphism.

- subtyping: instances of a subclass can be passed to a base class
- generics: instances of a function or a class are created by type parameterization.
