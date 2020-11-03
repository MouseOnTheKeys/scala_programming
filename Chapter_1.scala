//  Begining of the book

var capital = Map("US"->"Washington", "France"->"Paris", "Germany"->"Berlin")
capital += ("Japan"->"Tokyo")
println(capital("Germany"))

val msg = "Hello World!!!"
println(msg)

def factorial(x: Int): BigInt =
    if (x==0) 1 else x * factorial(x-1)

factorial(40)

import java.math.BigInteger

def factorial(x: BigInteger):BigInteger =
    if (x==BigInteger.ZERO)
        BigInteger.ONE
    else
        x.multiply(factorial(x.subtract(BigInteger.ONE)))

factorial(35)

val xs = 1 to 3
val it = xs.iterator
