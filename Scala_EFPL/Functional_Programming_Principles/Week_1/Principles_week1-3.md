### Week 1

#### Lecture 1.3

**Call-by-name, Call-by-value and termination**

If CBV evaluation of an expression ***e*** terminates, then CBN evaluation of ecpression terminates too.
The other direction is not true.

Expression that terminates under CBN but not under CBV.

```Scala
def first(x: Int, y: Int) = x
```
consider the expreson `first(1, loop)`

Under CBN:
`first(1, loop)`
yield 1

Under CBV:
`first (1, loop)`
we reduce loop to itself

Scala normally uses call-by-value.
But if the type of a function paramater start with => it uses call-by-name.

Example:
```Scala
def constOne(x: Int, y: => Int) = 1 // y will be passed CBN
```
Offten in practice CBV is exponentially more efficient than CBN because, its avoids the repeted recomputation of argument expressions that CBN intails.

Scala has an imperative side CBV is standard choice.

