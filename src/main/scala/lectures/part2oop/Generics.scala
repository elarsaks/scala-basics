package lectures.part2oop

object Generics extends App {

  // A generic class
  class MyList[A] {
    // The class can now store or handle elements of type A
    def add[B >: A](element: B):MyList[B] = ???
    /*
      A = Cat
      B = Animal
     */
  }

  class MyMap[Key, Value] // A generic map with key-value pairs

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Generic methods within a companion object
  object MyList {
    def empty[A]: MyList[A] = new MyList[A] // Implementation of the empty method returning a new MyList of type A
  }

  val emptyListOfIntegers = MyList.empty[Int] // Creates an empty list of integers

  // Variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. Covariance
  class CovariantList[+A] // Using +A to indicate covariance
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat] // This works due to covariance
  // animalList.add(new Dog) ??? HARD QUESTION => We return list of animals

  // 2. Invariance
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal] // Type must exactly match

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types (upper vs lower bounded types)
  class Cage[A <: Animal](Animal: A) // Subclasses of Animal
  val cage = new Cage(new Dog)

  class Car
  // Generic type needs proper bounded type
  // val newCage = new Cage(new Car) <-- Will produce error

  // expand MyList to the Generic
}
