### Week 4

#### Lecture 4.2

Functions as Objects

We have seen that Scala's numeric types and the Boolean types can be implemented like normal classes.

Functions ???

In fact function values are treated as objects in Scala.

The function typer A => B is just an abbrevation for the class scala.Function[A, B], which is roughly define as follows"

```Scala
package scala
trait Function`[A,B] {
    def apply(x: A): B
}
```

So functions are objects with apply methods.
There are also traits Function2, Function3... for functions that takes more parameters (currently up to 22).

Expansion of Function Values
An anonymous function such as
`(x: Int) => x * x`
is expanded to:

```Scala
{class AnonFun extends Function1[Int, Int]{
    def apply(x: Int) = x * x
}
def AnonFun
}
```

or shoreter, using Anonymous class syntax:

```Scala
new Function1[Int, Int] {
    def apply(x: Int) = x*x
}
```

Expansion of function calls

A function call, such as f(a,b) where f is a value of some class type, is expanded to:
`f.apply(a,b)`
So the OO-translation of:

```Scala
val f = (x: Int) => x*x
f(7)
```

would be

```Scala
val f = new Function1[Int, Int] {
    def apply(x: Int) = x*x
}
f.apply(7)
```
