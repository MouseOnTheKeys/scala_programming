package recfun


object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c <= 0 || c >= r)
      1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)


  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = def balance(chars: List[Char]): Boolean = {
    def pennyCount(cnt:Int, chr: Char, lst: List[Char]): Int = {
      var newCnt = cnt
      if(chr == '(') newCnt = cnt  + 1
      else if(chr == ')') newCnt = cnt  - 1

      if(newCnt < 0) newCnt
      else if(lst.isEmpty) newCnt
      else pCounter(newCnt, lst.head, lst.tail)

    }

    pCounter(0, 0, chars) == 0

  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeRec(currentMoney: Int, currentCoins: List[Int]): Int = {
      if (currentMoney == money)
        1
      else if (currentMoney > money || currentCoins.isEmpty)
        0
      else
        countChangeRec(currentMoney + currentCoins.head, currentCoins) +
          countChangeRec(currentMoney, currentCoins.tail)
    }

    countChangeRec(0, coins)
  }
}

