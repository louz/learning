package io.jasonlu.scalajdk8patterns.scala

/**
  * Created by louz on 2016/10/10.
  */
object ImmutableScalaObject {
  def main(args: Array[String]): Unit = {
    val obj = new ImmutableScalaClass(
      a = 10,
      b = 20,
      c = 30,
      d = 40
    )

    print(obj)
  }
}
