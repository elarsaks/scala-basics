package lectures.part1basics

object ValuesVariablesTypes extends App {
  // Vals are immutable
  val x: Int = 42
  val y = 24 // Compiler can infer types
  println(x)
  println(y)

  val aString: String = "Hello, this is a string!"
  val aBoolean: Boolean = true
  val aChar: Char = 'a'

  val aShort: Short = 4656 // 2 bytes
  val anInt: Int = x // 4 bytes
  val aLong: Long = 54656456768879L // 8 bytes (add 'L' at the end to mark that it is a Long)
  val aFloat: Float = 2.0f // Add 'f' to mark the float, not a double
  val aDouble: Double = 3.14 // Write any decimal values

  // Variables
  var aVariable: Int = 4 // Can be reassinged
  aVariable = 5 // side effects

}
