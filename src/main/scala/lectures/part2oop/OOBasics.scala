package lectures.part2oop

import java.time.LocalDate
import java.time.Year

object OOBasics extends App {

  val person = new Person("Elar", 35)
  println(person)
  println(person.x)

  person.greet("John")
  person.greet()


  val shakespeare = new Author(firstName = "William", surName = "Shakespeare", yearOfBirth = 1564)
  val hamlet = new Novel("Hamlet", 1601, shakespeare)

  println("Author.fullname: " + shakespeare.fullName())
  println("Novel.authorAge: " + hamlet.authorAge())
  println("Novel.isWrittenBy: " + hamlet.isWrittenBy())
  println("Novel.copy: " + hamlet.copy())

  val counter = new Counter
  println(counter.currentCount())
  counter.increment()
  println(counter.currentCount())
  counter.decrement()
  println(counter.currentCount())
  counter.increment(3)
  println(counter.currentCount())
  counter.decrement(2)
  println(counter.currentCount())
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


/*
  Novel and Writer
  Writer: first name, surname, year
    - method fullname

  Novel: name, year or release, author
    - AuthorAge
    - isWrittenBy(author)
    - copy (new year of release)
 */

class Author (firstName: String= "", surName: String = "", yearOfBirth: Int){
  def fullName(): String = firstName + ' ' + surName
  def age(): Int = {
    val currentYear =Year.now().getValue
    val age = currentYear - yearOfBirth

    age
  }
}

class Novel(name: String, yearOfRelease: Int, author: Author){
  def authorAge(): Int = author.age()
  def isWrittenBy(): String = author.fullName()
  def copy(): Int = yearOfRelease
}

class Counter(){
  var count = 0

  def currentCount(): Int = this.count
  def increment(): Unit = {
    count = (count + 1)
  }

  def decrement(): Unit = {
    count = count - 1
  }

  // overloading
  def increment(valueToAdd: Int): Unit = {
    count = count + valueToAdd
  }

  def decrement(valueToMinus: Int): Unit = {
    count = count - valueToMinus
  }

}


/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */







