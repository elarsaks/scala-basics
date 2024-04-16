package lectures.part1basics

object CBNvsCBV extends App{
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = { // x gets evaluated during every func call
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  /*
  by value: 88338320112700
  by value: 88338320112700
  by name: 88338389294000
  by name: 88338390237500 // Value changes because the x got reevaluated
  */

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x) // Does not cause stack overflow, because y is never accessed

  //printFirst(infinite(), 34)
  printFirst(34, infinite())
}
