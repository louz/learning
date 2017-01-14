package io.jasonlu.scala

/**
  * Created by jiehenglu on 17/01/12.
  */
object CollectionDemo {
  def main(args: Array[String]): Unit = {
    val testSet: Set[String] = Set()
    printf(testSet.headOption.getOrElse("None"))
  }
}
