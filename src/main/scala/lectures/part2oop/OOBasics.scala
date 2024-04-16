package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Elar", 35)
  println(person)
  println(person.x)

  person.greet("John")
  person.greet()
}

class Person(name: String, val age: Int = 0) { // constructor
  // body
  val x = 2 // This is a field and can be accessed

  println(1 + 3)

  // Method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name!")
  // If there is a parameter with the same name as a field in class, use 'this' keyword.
  // Otherwise 'this' keyword is implied.

  //Overloading
  def greet(): Unit = println(s"Hi, I am $name")
  // Compiler knows which 'greet' method to use, based on parameters passed to the method called.

  // Multiple constructors (overloading constructors)
  def this(name: String) = this(name, 0)
  def this() = this("John Dow")
  // There is no need for those secondary constructors, if we pass a default value in a class parameter.
}

// Class parameters are NOT FIELDS!
// To access them, add 'val' ||scala.App 'var' keyword.