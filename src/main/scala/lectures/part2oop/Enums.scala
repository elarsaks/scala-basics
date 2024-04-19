package lectures.part2oop

object Enums {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    def openDocument(): Unit = this match {
      case READ => println("Opening document...")
      case _ => println("Reading not allowed.")
    }
  }

  val somePermissions: Permissions = Permissions.READ

  enum PermissionWithBits(bits: Int) {
    case READ extends PermissionWithBits(4) // 100 in binary
    case WRITE extends PermissionWithBits(2) // 010 in binary
    case EXECUTE extends PermissionWithBits(1) // 001 in binary
    case NONE extends PermissionWithBits(0) // 000 in binary
  }

  object PermissionWithBits {
    def fromBits(bits: Int): PermissionWithBits = bits match {
      case 4 => PermissionWithBits.READ
      case 2 => PermissionWithBits.WRITE
      case 1 => PermissionWithBits.EXECUTE
      case 0 => PermissionWithBits.NONE
      case _ => throw new IllegalArgumentException("Invalid bits for permissions")
    }
  }

  // Standard API
  val somePermissionsOrdinal = somePermissions.ordinal
  val allPermissions = PermissionWithBits.values // Array of all possible values of the enum
  val readPermission: Permissions = Permissions.valueOf("READ")

  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
    println(s"Ordinal of READ: $somePermissionsOrdinal")
    println(s"All permissions: ${allPermissions.mkString(", ")}")
    println(s"Permission from 'READ': $readPermission")
  }

}
