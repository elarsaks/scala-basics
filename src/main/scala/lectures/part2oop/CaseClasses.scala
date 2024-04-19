package lectures.part2oop

object CaseClasses extends App {

  /*

  equals, hashConde, toString
   */

  case class Person(name: String, age: Int)

  // 1. class parameters are promoted to fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance= = println(instance.toString) // syntatic sugar
  println(jim)

  // 3. equal and hashcode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. CCs have companion objects ***
  val thePerson = Person
  // We dont need to use keyword 'new' when instaniationg case class
  val mary = Person("Mary", 23)

  // 6. CCs are serializable
  // Akka

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
    Expand MyList - use case classes and case objects
   */
}
