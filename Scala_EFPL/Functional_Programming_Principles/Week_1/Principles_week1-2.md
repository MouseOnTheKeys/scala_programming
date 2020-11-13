### Week 1

#### Lecture 1.2

Every non-trivial programming language provides:

* primitive *expressions* representing the simple elements
* ways to combine expressons
* ways to *abstract expressions*, which introduce a name for an expression by whichit can than be reffered to.

A non-primitive expression is evaluated as follows.

1. Take the leftmost operator
2. Evaluate its operands (left before right)
3. Apply the operator to the operands

A name is evaluated by replacing it with the right hand side of its definintion.
The evaluation process stop once it results its value.
A value is a number (for the moment)
Later on we will consider also other kinds of values.

Here is evaluatiion of arithmetic expression

```Scala
def radius = 10
def pi = 3.14159

(2 * pi) * radius
(2 * 3.14159) * radius
6.28318 * radius
6.28318 * 10
62.8318
```
definitions can also have parameters. For instance:
```Scala
def square(x: Double) = x * x

square(2)

square(5 + 4)
```
```Scala
def sumOfSquares(x: Double, y: Double) = square(x) + square(y)

sumOfSquares(3,9)

```
Function parameters come with their type, which is given after a colon
```Scala
def power(x: Double, y:Int): Double = ...
```
If return type is given it folloes the parameter list.
Primitive types are as in Java, but are written capitalized:
Int - 32-bit Integer
Double - 64-bit Integer
Boolean - boolean values true and false

Applications are parameterized functions are evaluated the similar way as operators:

1. Evaluate all function arguments, from left to right
2. Replacethe function application by the function`s right-hand sid, and at the same time
3. Replace the formal patameters of the function by the actual arguments.
```
evaluation goes like this:
sumOfSquares(3, 2+2)
sumOfSquares(3,4)
square(3) + square(4)
3 * 3 + square(4)
9 + square(4)
9 + 4*4
9 + 16
25
```
**The substitution model**

The scheme of expression is called the *substitution model*.
The idea underlyingthis model is that all evaluation does is ***reduce*** an *expression* to a *value*.
It can be applied to all expressions, as long as they have no side effects.
The substitutional model is formalized in *$\lambda$-calculus*, which gives a foundation for functional programming.

Side effect is are for exaple `i++`  in C or Java programming.
n other words the expression C++ has a side effect on the current value of the variable.
And that side effect cannot be expressed
by the substitution model. So one of the motivations for ruling out
side effects in function programming is that we can keep to the simple model of
evaluation.

we can't increment variable if we don't store it so this expression does not work in Scala.
We can use `i += 1`.

**Termination**

Does every expression reduce to a value (in a finite number of steps) ?
No. Here is counter-example
```Scala
def lop: Int = loop
loop //we reduced the name to itself
```
**Changing the evaluation strategy**
The interpreter reduces function atguments to values before rewritting the function application.
One could alternatevely apply the function to unreduced arguments.
For instance:
```Scala
sumOfSquares(3,2+2)
square(3) + square(2+2)
3 * 3 + square(2 + 2)
9 + square(2+2)
9 + (2+2) * (2+2)
9 + 4 + (2+2)
9 + 4 * 4
25
```
**Call-by-name and Call-by-value**

The first evaluation strategy is known as call-by-value, the second is known as call-by-name.

Both strategies reduce to the same values as long as
* the reduced expression cosists of pure functions, and
* both evaluations terminate.

Call-by-value has the advantage that it evaluates every function argument only once.
Call-by-name has the advantage that a function argument is not evaluated if the corresponding parameter is unused in the evaluation of the function body.
