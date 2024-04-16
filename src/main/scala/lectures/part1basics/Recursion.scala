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

  @scala.annotation.tailrec
  def concatenateTailRec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailRec(aString, n-1, aString + accumulator)

  println(concatenateTailRec("hello ", 3, ""))



  def isPrime(n: Int): Boolean = {
    @scala.annotation.tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean =
      if(!isStillPrime) false
      else if(t <= 1) true
      else isPrimeTailRec(t-1, n % t != 0 && isStillPrime)

    isPrimeTailRec(n / 2, true)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(2001))

  def fibonacci(n: Int): Int = {
    @scala.annotation.tailrec
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(3, 1, 1)
  }
  
  println(fibonacci(8))

}