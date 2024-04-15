package lectures.part1basics

object Expressions extends App{

  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4) // Math expression
  // + - * / & | << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ..... side effects
  println(aVariable)

  // Instruction (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) "Condition is TRUE" else "Condition is FALSE" // In Scala we use Expressions (everything returns value)
  println(aConditionedValue)

  // AVOID WHILE LOOPS IN SCALA.
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // Because EVERYTHING in Scala is expression.

  // Side Effects in Scala are expressions returning Unit

  var aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue) // Only value a Unit type can hold is: ()

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z > 2) "hello" else "goodbye"
  } // Code blocks ara also expressions

  // The value of a code block is the value of the last expression in it
  println(aCodeBlock)

  // val anotherValue = z + 1 // Cannot resolve 'z' because it is declared inside the code block.

  // 1. Difference between "hello world" vs println("hello world")?
  // One is string literal, other is an expression causing a side effect (Unit)

  // 2.
  val someOtherValue = {
    2 < 3
  }

  val someOtherValue2 = {
  //   if(someValue)239 else 986
    42
  }

}


