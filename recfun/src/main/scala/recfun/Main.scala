package recfun

object Main {
  def main(args: Array[String]) {
    /*println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }*/
    println(countChange(4, List(1, 2)))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = ???
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      def score(counter: Int, l: List[Char]): Int = {
        if(l.isEmpty) {
          0
        } else if(l.head == '(') {
          score(counter + 1, l.tail)
        } else if(l.head == ')'){
          if(counter <= 0) {
            -1
          }
          else {
            score(counter -1, l.tail)
          }
        } else {
          score(counter, l.tail)
        }
      }

      score(0, chars) == 0
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {


      def forCoin(remaining: Int, coins: List[Int]): Int = {
        val temp = remaining - coins.head

        if(temp > 0) {
          forCoin(temp, coins)
        }
        else if(temp < 0) {
          forCoin(remaining, coins.tail)
        }
        else {
          1
        }
      }

      forCoin(money, coins.sorted(Ordering[Int].reverse))
    }
  }
