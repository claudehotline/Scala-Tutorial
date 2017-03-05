package typelessdomore

import scala.annotation.tailrec

object Factorial {
  def main(args: Array[String]) =
    (0 to 5) foreach(i => println(factorial(i)))

  def factorial(i: Int): Long = {
    @tailrec
    def fact(i: Int, accumulator: Int): Long = {
      if(i <= 1) accumulator
      else fact(i - 1, i * accumulator)
    }

    fact(i, 1)
  }
}