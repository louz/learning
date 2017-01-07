import io.jasonlu.scalajdk8patterns.scala.User

object ScalaFunction {
  def main(args: Array[String]): Unit = {
    val user1 = User(1, "user1")
    val user2 = User(2, "user2")
    val user3 = User(3, "user3")

    val users = List(user3, user2, user1)

    val newUsers = users.sortWith((u1, u2) => u1.id < u2.id)
    newUsers.foreach(u => print(u))
  }
}