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
  val fakeShakespeare = new Author(firstName = "William", surName = "Shakespeare", yearOfBirth = 1564)
  val hamlet = new Novel("Hamlet", 1601, shakespeare)

  println(hamlet.isWrittenBy(fakeShakespeare))

  val counter = new Counter(0)
  counter.inc.print
  counter.inc.inc.inc.print // TODO: Go through the recurion in OOP!
  counter.inc(10).print

  /*
  println("Author.fullname: " + shakespeare.fullName())
  println("Novel.authorAge: " + hamlet.authorAge())
  println("Novel.isWrittenBy: " + hamlet.isWrittenBy())
  println("Novel.copy: " + hamlet.copy())
   */

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
  def isWrittenBy(author: Author) = author == this.author
  def copy(): Int = yearOfRelease
}

/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */

class Counter(val count: Int){
  // In FP instances are fixed and cannot be modified inside.
  // Whenever we need to modify it, we will return a new instance

  def inc = new Counter(count + 1) // immutability
  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int) = new Counter(count + n)
  def dec(n: Int) = {
    if(n <= 0) this // Return current count
    else inc.inc(n-1) // Use recursion to decrement
  }

  def print = println(count)
}






