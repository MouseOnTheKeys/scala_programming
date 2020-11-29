import week3.Rational
// import wek3._  - will import everything from package week3

object scratch {
  new Rational(1,2)

  def error(msg: String) = throw new Error(msg) //error: (msg: String)Nothing

  error("test")

  val x = null
  val y: String = null //y: String = null
  val z: Int = null  // error: an expression of type Null is ineligible for implicit conversion
  if (true) 1 else false // AnyVal = 1
}