### Week 3

#### Lecture 2.3

**Finding Fixed Points**

A number is called fixed point of a function f if:
` f(x)= x`
for some functions f we can locate the fixed points by starting with an initial estimate andthan by applying f in same repetitive way.
`x, f(x), f(f(x)), f(f(f(x))), ...`
until the value does not vary anymore(or the change is sufficiently small).

This leads to the following function for finding a fixed point:

```Scala
val tolerance = 0.0001
def isCloseEnough(x: Double, y: Double) =
    abs((x-y) / x) < tolerance
def fixedPoint(f: Double => Double)(firstGuess: Double)= {
    def iterate(guess: Double): Double = {
        val next = f(guess)
        if (isCloseEnough(guess, next)) next
        else iterate(next)
    }
    iterate(firstGuess)
}
```
Return to square roots
Here is a ***specification*** of the squaret function:
`sqrt(x) = the number y such that y * y = x`
Or, by dividing both sides of equation with y:
`sqrt(x) = the number such that y = x / y`
Consequently, sqrt(x) is a fixed point of function (y => x / y).

This suggests to calculate sqrt(x) by iteration towards a fixed point:
```Scala
def sqrt(x: Double) =
    fixedPoint(y => x / y)(1.0) //function that maps y -> x/y
```
Unfortunately this does not converge.
Let's add a println instruction to the function `fixedPoint` so we can follow the current value of guess.

One way to control such oscillations it to prevent the estimation from varying too much. This is done by *averaging* succcesive values of the original sequence:
```Scala
def sqrt(x: Double) = fixedPoint(y => (x /t) / 2)(1)
```
This produces:

1.5
1.416666
1.414215627
1.424213746
1.424213746

In fact, if we expand the fixed point function `fixedPoint` we find a similar square root function to what we developed last week.

**Functions as Return Values**

The previous example have shown that the wxpressive power of a language is greately increased if we can pass functional arguments.
The following example shows that functions tha return functions can be very useful.
Consider again iteration towards fixed point.
we began by observing that $\sqrt{x}$ is fixed point of the function y => x / y.
Then, the iteration converges by averaging successive values.
The techniques of stabilizing by averaging is general enough to merit being abstracted into its own function.
```Scala
def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
```
