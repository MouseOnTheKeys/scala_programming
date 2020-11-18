### Week 2

#### Lecture 2.2

**Currying**

```Scala
def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
        if (a>b) 0
        else f(a) + sumF(a + 1,b)
    sumF
}
```
Sum is now a function that returns another function.
The returned function sumF applies the given function parameter f and sums the result.

**Multiple parameter list**

The definition of functions that return the function is so usful that there is a special syntax for it in Scala.
For example, the following definition of sum is equivvalenttothe onewith the nested sumFfunction, but shorter:
```Scala
def sum(f: Int => Int)(a:Int, b: Int): Int =
    if (a>b) 0 else f(a) + sum(f)(a + 1, b)
```
Question ???
`def sum(f: Int =>Int)(a:int. b: Int): Int =...`
What is the type of sum ???
Answer:
`(Int => Int) => (Int, Int) => Int`
Note, that function type associate to the right. That is to say that
`Int => Int = > Int`
is equivalent to:
`Int => (Int => Int)`

