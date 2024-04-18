package lectures.part2oop

// Does not need to extend app if using def main method
object Objects  {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person { // type + its ONLY instance
    // "static"/"class" - level functionality
    val N_EYEZ = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANIONS

  def main(args: Array[String]): Unit = {
    println(Person.N_EYEZ)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john) // FALSE

    val person1 = Person
    val person2 = Person
    println(person1 == person2) // TRUE

    val bobbie = Person.apply(mary, john)

  }

  // Scala Applications = Scala object with
  // def main(args: Array[String): unit
}
