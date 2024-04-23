package exercises

import scala.annotation.tailrec

object SocialNetwork extends App {
  /*
   * A simple social network model where:
   * - 'network' is a Map where each person (String) is associated with a set of friends (Set[String]).
   * - Functions to add and remove people from the network, manage friendships and analyze the network.
   */

  // Adds a new person to the network with no friends initially.
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  // Establishes a mutual friendship between two people.
  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network.getOrElse(a, Set()) // Retrieves or initializes friend list for 'a'
    val friendsB = network.getOrElse(b, Set()) // Retrieves or initializes friend list for 'b'

    network + (a -> (friendsA + b)) + (b -> (friendsB + a)) // Adds each person to the other's friend list
  }

  // Removes a mutual friendship between two people.
  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network.getOrElse(a, Set())
    val friendsB = network.getOrElse(b, Set())

    network + (a -> (friendsA - b)) + (b -> (friendsB - a)) // Removes each person from the other's friend list
  }

  // Removes a person entirely from the network, including all their friendships.
  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    @tailrec
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head)) // Recursively unfriend each friend

    val unfriended = removeAux(network.getOrElse(person, Set()), network)
    unfriended - person // Removes the person from the network
  }

  // Example of how the network is used
  val empty: Map[String, Set[String]] = Map()
  val initialNetwork = add(add(empty, "Bob"), "Mary") // Add Bob to empty network, then add mary to the network containing bob
  println("Intial network: " + initialNetwork)
  println(friend(initialNetwork, "Bob", "Mary")) // Add Bob to mary friends and vice versa
  println(unfriend(friend(initialNetwork, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(initialNetwork, "Bob", "Mary"), "Bob"))

  // More complex example of network usage
  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  // Returns the number of friends a person has in the network.
  def nFriends(network: Map[String, Set[String]], person: String): Int =
    network.getOrElse(person, Set()).size

  println(nFriends(testNet, "Bob"))

  // Determines which person has the most friends in the network.
  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  // Counts how many people in the network have no friends.
  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.count(_._2.isEmpty)

  println(nPeopleWithNoFriends(testNet))

  // Determines if there is a social connection (direct or indirect) between two people.
  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network.getOrElse(person, Set()))
      }
    }

    bfs(b, Set(), network.getOrElse(a, Set()) + a) // Starts BFS from person 'a' to find 'b'
  }

  println(socialConnection(testNet, "Mary", "Jim"))
  println(socialConnection(initialNetwork, "Mary", "Bob"))
}
