### Week 1

#### Lecture 1.5

**Square root function with Newton method**

We want to define a function with a signature. It takes a Double and gives back a double, and return value is a square root of its parameter x.

Newton`s method to compute sqrt(x):

1. Staring with estimate value
2. Repetedly improve the estimate by taking the mean of y and x/y

A typical way to code algorithms in functional languages is to go step by
step.
So, we take a small task and formulate it as a function and then probably, that task will need further tasks that then would be defined in their own function.

```Scala
def squareUter(guess: Double, x: Double): Double =
    if (isGoodEnough(gues, x)) guess
    else squrtIter(improve(guess, x), x)
```
*sqrtIter* is ***recursive***, its right-hand side calls itself. Recursive functionsneed an explicit return type in Scala.
For non-recurcive functions, the type is optional.

Exercise:
1. The isGoodEnough(~/week1/Scripts/sqrt_func.scala) function is not very precise for small numbersand can lead to non-termination for very large numbers.

Problems we have for very small numbers and large numbers was that our isGoodEnough function take onluy absolute numbers.
And for large numbers w have the opposite problem the two numbers are to  far away from each other