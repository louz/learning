package io.jasonlu.scalajdk8patterns.scala

/**
  * Created by louz on 2016/10/10.
  */
object CaseScalaObject {
  def main(args: Array[String]): Unit = {
    val obj = new CaseScalaClass(
      a = 10,
      b = 20,
      c = 30,
      d = 40
    )

    print(obj)
  }
}
