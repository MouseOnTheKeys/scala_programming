## Functional Programming Principles in Scala

### Week 1

#### Lecture 1.1

Main programming paradigms:
* imperative programming
* functional programming
* logic programming

Orthogonal to it:
* object-oriented programming

Impreative programming is about.
* modifying mutuble variables
* using asssognments
* and control structures such as if-than-else, loops, break, continue, return

The most common informal way to understand imperative programs is as instruction sequence for a Von Neumann computer.

In the end imperatice programming is limited by the Von Neumann bottleneck:

*One tends to conceptualize data structure word-by-word*

We need other techicues for defining high-level abstraction such as collections, polynomials, geometric shapes, strings, documents.
Ideally: Develop *theories* of collection, shapes, strings...

Theory consists of:
* One or more data types
* Operation types
* Laws to describe the relationaships between values and operations

Normally  theory does not describe **mutations** !

Mutations means changing something while keeping the indentity of samthing same.

For instance the theory of polynomials defines the sum of two polynomials by laws such as:
```latex
( a*x+b ) + ( c*x+d ) = ( a+c )*x + ( b+c )
```
But it does not define the operator to change a coefficient while keeping the polynomial the same!

*Other Example*:
Theory of strings defines a concatination operator ++ which is associative:
```latex
(a ++ b) ++ c = a ++ (b ++ c)
```
But it does not define an operator to change a sequence element while keeping the sequence same!

If we want to implement high-level concepts following their mathematical theories there are no place for mutation.
* theories do not admit it
* Mutatuions can destroy useful laws in the theories.

Therefore, let`s crate new style o programming:
* concetrate on defining  theories  for ooperators expressed as functions
* avoid mutations
* have powerful ways to abstract and compose functions.

**Functional Programming**

In a restricted sense, functional programming (FP) means programming without mutable variables, ssignments, loops, and other imperative controle stuctures.

In a wider sense, functional programming means focusing on the functions.

In a perticular, functions can be values that are produced, consumed, and composed.

All this becomes easier in a functional language.

In the restricted sense then a functual programming language is one which does not have an immutable variables assignments or imperative control structure.

In a wider sense, a functional programming language enables the construction of e;egant programs that docus on functions.

In particular, fucnctions on a FP language are the First-class citizens.
* they can be defined enywhere
* like any value, they can bepassed as parameters to functions and returned as results.
* as for other values, there exists a set of operators to compose functions.