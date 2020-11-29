package week3

class Rational(x: Int, y: Int) {
    require(y != 0, """|denominator must be positive number""".stripMargin)

    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = if (b==0) a else gcd(b, a % b) // method of class rationasl  it is PRIVATE strictly for implementation purposes
    // private val g = gcd(x, y)
    //def numer = x / g
    //def denom = y / g
    def numer = x
    def denom = y

    def add(that: Rational) =
        new Rational(
            numer * that.denom + that.numer * denom,
            denom * that.denom
        )
    def neg: Rational = new Rational(-numer, denom)

    def sub(that: Rational) =
        new Rational(
            numer * that.denom - that.numer * denom, // dry principle dont repet ypurself xD
            denom * that.denom)
    //def sub(that: Rational) = add(that.neg)
    def < (that: Rational) = numer * that.denom < that.numer *denom

    def max(that: Rational) = if (this < that) that else this // this is known also as self in OO Programming laguages (Python)

    override def toString= {
        val g = gcd(numer, denom)
        numer/g + "/" + denom/g // + is String concatination
    }
}