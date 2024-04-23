package lectures.part3fp

object TuplesAndMaps extends App {

  // Tuples = finite ordered "lists"
  val aTuple = (2, "Hello Scala") // Simplified syntax
  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "Good bye Java")) // Copy with modified element
  println(aTuple.swap) // Swaps elements

  // Maps - keys -> values
  val phonebook = Map("Jim" -> 555, "Daniel" -> 789).withDefaultValue(-1)
  println(phonebook)

  // Map operations
  println(phonebook.contains("Jim"))
  println(phonebook("Mary")) // Accesses default value since "Mary" is not a key

  // Adding a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // Functionals on maps
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // FilterKeys and MapValues
  // Convert to Map to force computation and show results
  println(phonebook.filterKeys(_.startsWith("J")).toMap)
  println(phonebook.mapValues(_ * 10).toMap)

  // conversions to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))
}
