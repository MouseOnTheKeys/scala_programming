### Week 1

#### Lecture 1.6

Nested Functions

It's good, programming style, particularly in functional programming, to split up a task into many small functions. But on the other hand, names like square root iter improve and is good enough, they really matter for only the implementation of square root not for its usage.

Normally we would not want to users to access this functions directly.

We can archive this and at the same time avoid "name-space pollution" by putting the auxciliary function inside sqrt.

**Block in Scala**

A block is delimiter by braces { ... }
```Scala
{   val x = f(3)
    x*x
}
```
It contains a sequence of definitions or expressions.
The last element of a block is an expression that defines its value.
This return expression can be preceded by auxilary definitions.
Blocks are themselves expressions, a block may appear everywere and expression can.

Blocks and Visability

The definition inside of block is only visible from inside of block.
The definitions inside a block shadow definition of the same names ouside the block.

**Lexical Scoping**

Definition of outer blocks are visible inside a block unless they are shadowed.
Therefore, we can simly sqrt by eliminating redudant ocurrencec of the x parameter, which means everywhere the same thing.

**Semicolons**

In Scala, semicolons at the end of lines are in most cases optional.
We can write `val x = 1;`
but most people would omit the semicolon.
On the other hand, if there are more than one statment on a line, they need to be separatedby semicolons:
`val y = x+1 ; y*y `
these are two expressions and need to be able separate them.

If line of code ends with the infix operator the Scala compiler will asume that code is not yet finished.

**Tail Recursion**

Implementation Consideration: If a function calls itsel as its last action,the functon`s stack frame can be reused.
This is called *tail recursion*

=> Tail recursive functions are iterative processes.

In general, if the last function consist of calling a function (which may be the same), one stack frame would be sufficient for both functions. Such calls are called tail-calls.

In Scala, only directly recursive calls to functions are optimized.
One can require that a function is tail-recursive using @tailrec annotation:

```Scala
@tailrec
def gcd(a: Int, b: Int): Int = ...
```
If annotation is given, the implementation of gcd were not tail recursive, an error would be given.