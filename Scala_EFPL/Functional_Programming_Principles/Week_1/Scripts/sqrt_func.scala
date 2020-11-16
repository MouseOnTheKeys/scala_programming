// object sqrt_func {
//     def abs(x: Double) = if (x < 0) -x else x

//     def sqrt(x: Double) = {

//     def sqrtIter(guess: Double, x: Double): Double =
//         if (isGoodEnough(guess, x)) guess
//         else sqrtIter(improve(guess, x), x)

//     def isGoodEnough(guess: Double, x: Double) =
//         abs(guess * guess -x) / x  < 0.001

//     def improve(guess: Double, x: Double) =
//     (guess + x / guess) / 2

//     sqrtIter(1.0, x)

//     }
//     sqrt(121)
//     sqrt(1e60)
//     sqrt(1e-6)
// }

object sqrt_func {
    def abs(x: Double) = if (x < 0) -x else x

    def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
        if (isGoodEnough(guess)) guess
        else sqrtIter(improve(guess)) // x is now everywere the same

    def isGoodEnough(guess: Double) = // we are removing x and eliminate redudancy
        abs(guess * guess - x) / x  < 0.001

    def improve(guess: Double) =
    (guess + x / guess) / 2

    sqrtIter(1.0, x)

    }
    sqrt(121)
    sqrt(1e60)
    sqrt(1e-6)
}
