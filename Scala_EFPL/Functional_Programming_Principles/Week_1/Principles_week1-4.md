### Week 1

#### Lecture 1.4

Conditional Expressions

To express choosing between two alternatives, Scala has a contitional expression if-else.

It looks like a if-else in Java but its used for expressions not statments.

Example:
```Scala
def abs(x: Int) = if (x >= 0) x else -x
```
`x >= 0` is a *predicate*, of boolean type.

**Boolean expressions** b can be composed of:
```Scala
true false // Constants
!b // Negation <NOT>
b && b //Conjuction <AND>
b || b // Disjunction <OR>
```
and of the usual comparation operations:

`e<=e, e>=e, e<e, e>e, e==e, e!=e`

&& and || use "short circuit evaluation"

Value Definitions

we seen that function parameters can be passed by value or by name.
The same distinction applies to definitions.
The def form is "by-name", its right hand side is evaluated on each use.
There is also a `val` for, which is "by-name". Example:
```Scala
val x = 2
val y = square(2)
```
The right-hand side of a val definition is evaluated at the point of the definition itself.
Afterwards, the name refers to the value.
For instance, y above refers to 4, not square(2).

The difference between val and def becomes apparent when the right hand side does not terminate.
```Scala
def loop: Boolean = loop
```
A definition:
```Scala
def x = loop //is Ok
```
is OK, but a deffinition `def x = loop` will lead to infinite loop, because the RHS loop will be evaluated at the point of definition.

exercise:
```Scala
def and(x: Boolean, y: => Boolean) = if (x) y else false
```
