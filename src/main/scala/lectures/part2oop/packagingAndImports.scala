package lectures.part2oop
import playground.{Cinderella => Princess, PrinceCharming}

import java.util.Date
import java.sql.{Date => SqlDate}

object packagingAndImports extends App {

  // Package members are accessible by their simple name
  // OOBasics.Author
  val writer = new Author("Daniel", "RockTheJVM", 2018)

  // import the package
  val princess = new Princess // playground.Cinderella = fully qualified name

  // packages are in hierarchy
  // matching folder structure.

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // 1. Use fully qualified named
  val d = new Date
  val sqlDate = new SqlDate(2018, 5, 4)
  // 2. Use aliasing

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}
