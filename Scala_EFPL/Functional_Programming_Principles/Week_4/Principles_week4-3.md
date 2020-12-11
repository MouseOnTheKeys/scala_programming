### Week 4

#### Lecture 4.3

Subtyping and Generics

Polymorphism

Two principle forms of polymorphism:

- subtyping
- generics

In this session we look at their interactions.
Two main areas:

- Bounds
- Variance

Type Bounds

Consider the method assertAllPos which

- takes an IntSet
- returns the IntSet itself if all its elements are positive
- throws an exception otherwise

What would be the best type you can give to assertAllPos ?
Maybe:

```Scala
def assertAllPos(s: IntSet): IntSet
```

In most situations this is fine, but can one be more precise?

One might want to express that asserA;;Pos takes Empty sets to Empty sets and NonEmpty sets to NonEmpty sets.
A way to express this is:

```Scala
def assertAllPos[S <: IntSet](r: S): S = ...
```

Here, `<: IntSet` is an **_Upper Bound_** of the type perameter S:
It means that S can be instantiated only to the types that conform to IntSet.
Geneally, the notation:

- S <: T means : S is subtype of T, and
- S >: T means : S is supertype of T, or T is subtype of S.

**_Lower Bounds_**
You can also use a lower bounds for a type variable.
`[S >: NonEmpty]`
introduces a type parameter S that can range only over supertypes of NonEmpty.
So S could be one of NonEmpty, IntSet, AnyRef, or Any.
We will see later on in this session where lower bounds are useful.

**_Mixed Bounds_**
Finally it is also possible to mix a lower and upper bound.
For instance:
`[S >: NonEmpty <: IntSet]`
would restrict S any type to the interval between NonEmpty and IntSet.
