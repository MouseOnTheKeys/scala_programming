### Week 4

#### Lecture 4.5 - Pattern Matching

The task we are trying to solve is find the a general convinient way to access objects in a extensible class hierarchy.

**_Attempts seen previously: _**

- Classification and access methods: quadratic explosion
- Type tests and castsL unsafe, low-level
- Object-Oriented decomposition: does not always work, need to touch all classed to add new method

**_Solution 2: Functional Decomposition with Pattern Matching_**

Observation: the sole purpose of test and accessor functions is to reverse the construction process:

- Whisch subclass was used ?
- What were the arguments ?

This solution is so common that many functional languages, Scala included, automate it.

A case class ddefinition is simila to a normal class definition, except that it is preceded by modifier case. For example:

```Scala
trait Expr
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
```

Like before, this define a trait Expr, and two concrete subclasses Number and Sum.

It also implicitly defines companion objects with apply methods.

```Scala
object Number {
    def apply(n: Int) = new Number(n)
}
object Sum {
    def apply(e1: Expr, e2: Expr) = new Sum (e1, e2)
}
```

so you can write Number(1) instead of new Number(1).
However, these classes are now empty. So how can we access the members ?
