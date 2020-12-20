object week5 {
    val fruits = List("apples", "oranges", "lemons")
    val num= List(1,2,3)
    val diag3= List(List(1,0,0),List(0,1,0),List(0,0,1))
    val empty= Nil

    def remove[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n+1)
}