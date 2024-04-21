package lectures.part2oop
import playground.Cinderella

object packagingAndImports extends App {

  // Package members are accessible by their simple name
  // OOBasics.Author
  val writer = new Author("Daniel", "RockTheJVM", 2018)

  // import the package
  val princess = new Cinderella // playground.Cinderella = fully qualified name

  // packages are in hierarchy
  // matching folder structure.

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
}
