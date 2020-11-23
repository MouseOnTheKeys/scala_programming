### Week 2

#### Lecture 2.7

Classes and Substitutions

We previously defined the meaning of function applicattion using a computation model based on substitution. Now we extend this model to classes and objects.

How is an instantiation of class newC(e1,...,em) evaluated?

The expression arguments e1,...,em are evaluated like the arguments of a normal function. That's it.

The resulting expression, say, mew C(v1,..,vm) is already a value.

`new Rational(1, 2).numer`
-> `[1/x.2/y] [] [new Rational(1, 2)/this]x` = 1

```Scala
new Ratinal(1, 2).less(new Ratinal(2, 3))
-> [1/x, 2/x] [newRational(2, 3)/that] [new Rational(1, 2)/this]
    this.numer * that.denom < that.numer * this.denom
```
= new Rational(1, 2).numer * new Rational(2, 3).denom < new Rational(2,3).numer * new Rational(1,2).denom

-> 1 * 3 < 2 * 2
-> true

**Operators**

In principle, the rational numbers defined by Rational are as natural as integers.

But for the user of these abstractions, there is a noticeable difference:
- We write x + y, If x abd y are integers, but
- We write r.add(s) if r and s are rational numbers.

In Scala, we can eliminate this difference. We procede with two steps.

Operators can be identifiers.
Thus, an indetifier can be :
- Alphanumeric: starting with letter, followed by a sequence of letters or numbers
- Symbolic: starting with an operator symbol, followed buy other operator symbols.
- The underscore character '_' counts as a letter.
- Alphanumeric indentifiers can also end in an underscore, followed by some operator symmbols.

***Precedence Rules***

The precedence of an operator is determined by its first character.
The following table list the character in increasing order of priority precedence:

`(all letters)`
`|`
`^`
`&`
`< >`
`= !`
`:`
`+ -`
`* / %`
`(all other special character)`

