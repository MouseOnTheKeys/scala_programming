package recfun
import scala.annotation.tailrec
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
      pascal(c-1, r-1) + pascal(c, r-1)


  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
      @tailrec
      def balanceRec(currentChars: List[Char], count: Int): Boolean = {
      if (count < 0)
        false
      else if (currentChars.isEmpty)
        count == 0
      else if (currentChars.head == '(')
        balanceRec(currentChars.tail, count + 1)
      else if (currentChars.head == ')')
        balanceRec(currentChars.tail, count - 1)
      else
        balanceRec(currentChars.tail, count)
    }

    balanceRec(chars, 0)
  }

  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeReccurent(curMoney: Int, curCoins: List[Int]): Int = {
      if (curMoney == money)
        1
      else if (curMoney > money || curCoins.isEmpty)
        0
      else
        countChangeReccurent(curMoney + curCoins.head, curCoins) +
          countChangeRecccurent(curMoney, curCoins.tail)
    }

    countChangeReccurent(0, coins)
  }
}