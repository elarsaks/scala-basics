package lectures.part3fp

object AnonymosFunctions extends App {

  // anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2

  // multiple params in lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  // Careful!
  println(justDoSomething) // function itself
  println(justDoSomething())  // call

  // curly braces with lambdas
  val stringToInt = {
    (str: String) => str.toInt
  }

  // MOAR syntatic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equvalent to (a,b) => a + b

  /*
    1. MyList: replace all FunctionX calls with lambdas
    2. Rewrite the "special" adder as an anonymous function
   */
}
