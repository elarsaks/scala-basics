package lectures.part2oop

object InhertianceAndTraits extends App{

  // single class inheritance
  /* final */ class Animal {
    val creatureType ="wild"

    // private | protected | public (no modifier) | final (prevent overriding)
     final def eat = println("nom nom nom")
  }

  class Cat extends Animal {
     def crunch = {
       eat
       println("crunch crunch")
     }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0) // Auxiliary constructor
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String = "Domestic") extends Animal {
     // override val creatureType = "Domestic"
     override def eat = {
       super.eat // Will refer to the method eat in the super class
       println("crunch, crunch")
     }
  }

  // class Dog(dogType: String) extends Animal {
  //   override val creatureType = dogType
  //}

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // Preventing overrides
  // 1 - use the keyword final
  // 2 - use final on the entire class
  // 3 - seal the class = extends classes in THIS FILE, prevents extension in other files
}
