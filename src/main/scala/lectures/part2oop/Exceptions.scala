package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // this will crash with a NPE

  // 1. throwing and catching exceptions

  // val aWeirdValue: String = throw new NullPointerException()

  // throwable classes extend the Throwable class.
  // Exeptions and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No int for you")
    else 42

  val potentialFail = try {
    // code that might throw
    getInt(false)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // Code that will execute NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for the side effects
    println("finally")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  throw exception

  /*
   1. Crash your program with an OutOfMemoryError
   2. Crash with Stack Overflow Error
   3. PocketCalculator
      - add(x,y)
      - subtract(x,y)
      - multiply(x,y)
      - divide(x,y)

    Throw
      - OverflowExeption if add(x,y) exceeds Int.MAX_VALUE
      - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
   */
}
