### Week 4

#### Lecture 4.4

**Decomposition**

Suppose we want to write a small interpreter for arithmetic expression.
To keepo it simple, let's ourselves to numebers and hierarchy, eith a bse trait Expr and two subclasses, Number and Sum.

To treat an expression, it's necessary to know the expression's shape and its components.
This brings us to the folloeing implementation.

```Scala
trait Expr {
    def isNumber: Boolean
    def isSum: Boolean
    def numValue: Int
    def leftOp: Expr
    def rightOp: Expr
}
class Number(n: Int) extends Expr {
    def isNUmber: Boolean = true
    def isSum: Boolean = false
    def numValue: Int = n
    def leftOp: Expr = throw new Error("Number.leftOp")
    def rightOp: Expr = throw new Error("Numbre.rightOp")
}
```

```Scala
class Sum(e1: Expr,e2: Expr) extends Expr {
    def isNumber: Boolean = false
    def isSum: Boolean = true
    def numValue: Int = throw new Error("Sum.numValue")
    def leftOp: Expr = e1
    def rightOp: Expr = e2
}
```

Evaluation and expressions

Writting the evaluating function:

```Scala
def eval(e: Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("Unknown expression " + e)
}
```

**_Problem_**
Write all these classification and accessor functions quickly becomes tedious!

Adding new forms and expressions

if we want to add two new expression forms:

```Scala
class Prod(e1: Expr, e2: Expr) extends Expr
class Var(x: String) extends Expr
```

We need to add methods for classification and access to all classes that are defined above.

\*\*\*Non-Solution: Type Test and type Casts

A "hackey" solution coukld iuse tyoe test and type casts.
Scala let's you do these methods defined in class Any:

```Scala
def isInstanceOf[T]: Boolean    //  check wether this obect's type conforms to'T'
def asInstanceOf[T: T           // trets this object as an instance of type 'T'
                                // throws 'ClassException' if it isn't.
```

These coresponds to Java's type tests and casts

But their use in Scala is Discouraged, because there are better alternatives.

**_Eval with Type Tests and Type Casts_**

Here' formulation of the eval method using tests and casts:

```Scala
def eval(e: Expr): Int =
    if (e.isInstanceOf[Number])
        e.asInstanceOf[Number].numValue
    else if (e.isInstanceOf[Sum])
        eval(e.asInstanceOf[Sum].leftOp +
        eval(e.asInstanceOf[Number].rightOp)
    else trow new Error("Unknown expression " + e)
```

Assessment of this solution:

(+) - No need for classification methods, acess methods only for classes where the value is defined
(-) - Low-level and potentioally unsafe.

**_Object-Oriented Decompossition_**

For example, suppose that all you want to do is evaluateexpressions.
We could define:

```Scala
trait Expr {
    def eval: Int
}
class Number(n: Int) extebds Expr {
    def eval: Int = n
}
class Sum(e1: Expr, e2: Expr) etends Expr {
    def eval: Int = e1.eval + e2.eval
}
```

But what happens if we`d like to display expression now ?
We have to define new method in all the subclasses.
