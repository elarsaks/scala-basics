package lectures.part1basics

object Recursion extends App{

  // A factorial
  def aFactorialFunction(n: Int): Int = {
    if (n == 0) 1
    else {
      println("Computing factorial of " + n + " - I first need a factorial of " + (n-1))
      val result = n * aFactorialFunction(n - 1)
      println("Computed factorial of " + n )
      result
    }
  }

  println(aFactorialFunction(10))
  // println(aFactorialFunction((5000))) <-- THIS WILL CAUSE STACK OVERFLOW!!!

  def anotherFactorial(n: Int): BigInt = {
    @scala.annotation.tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  /*
  anotherFactorial(10) = factHelper(10, 1)
  = factHelper(9, 10 * 1)
  = factHelper(8, 9 * 10 * 1)
  = factHelper(7, 8 * 9 * 10 * 1)
  ....
  = factHelper(2, 3 * 4 * ... *  10 * 1)
  = factHelper(1, 1 * 2 * 3 * 4 * ... * 10)
  = 1 * 2 * 3 * 4 * ... * 10
  */

  println(anotherFactorial(5000))

  // WHEN YOU NEED LOOPS, USE_TAIL_ RECURSION

  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function
   */
}
