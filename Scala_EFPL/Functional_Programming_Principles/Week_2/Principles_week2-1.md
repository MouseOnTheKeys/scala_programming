### Week 2

#### Lecture 2.1

**Higher Order Functions**

Fanctional languages treat functions as first-class values.
This mean that like any value a function can be passed as a parameter and returned as a result.
This provides a flexibile way to compose a programs.
Functions that take other functions as parameters or that return functions are called higher order functions.

First order functions are the ones that acts on data types or lists, but not like higher order functions that acts on other functions.
```Scala
def sumInts(a: Int, b: Int): Int =
    if (a>b) 0 else a + sumInts(a + b)

def cube(x: Int): Int = x * x * x

def sumCubes(a: Int, b: Int): Int =
    if (a>b) 0 else cube(a) + sumCubes(a + 1, b)
```
**Summing with higher order Functions**
```Scala
def sum(f: Int => Int, a:Int, b:Int): Int =
    if(a>b) 0
    else f(a) + sum(f,a+1,b)
```
We can write:
```Scala
def sumInts(a: Int, b: Int): Int = sum(id,a,b)
def sumCubes(a: Int, b: Int): Int = sum(cube, a, b)
def sumFactorials(a: Int, b: Int): Int = sum(fact,a ,b)
```
where:
```Scala
def id(x: Int): Int =x
def cube(x:Int): Int = x*x*x
def fact(x: Int): Int = if (x==0) else fact(x-1)
```
**Function Type**

The type A => B is the type of a function that takes an argument of a type A and returns a result of a type B.

So, Int => Int is the type of functions that map integers to integers.

**Anonymous Functions**

Passing function as parameters leads to creation of many small functions
- Sometimes its tedious to have to define (and name) these functions using def .

Compare to Strings, we do not need to define strings using def.
Instead of `def str = "abc"`
We can directly  write:
`println("abc")`
because strings exist as literals. Analogiously we would like function literals, which lets us write a function without giving it a name.
They are called ***anonymous functions***

Example: A function tha rises its argument to a cube:
`(x: Int, y: Int) => x * x * x`
Here, `(x: Int)` is the parameter of the punction, and `x * x * x ` is its body.
- The type of the parameter can be omitted if it can be interred by the compiler from the context.

If there are several parameters they are seperated by commas:
`(x: Int, y: Int) => x + y`

One can say that anonymous function are syntactic sugar.

