package io.jasonlu.scalajdk8patterns.scala

/**
  * Created by louz on 2016/10/10.
  */
object TupleDemo {
  def main(args: Array[String]): Unit = {
    val t = (1, 2, 3, 4, 5)

    print(t._1, t._2, t._3, t._4, t._5)
  }
}
