package io.jasonlu.scalajdk8patterns.scala

/**
  * Created by louz on 2016/10/10.
  */
class ImmutableScalaClass(
  val a:Int,
  val b:Int,
  val c:Int = 1,
  val d:Int = 2,
  val e:Int = 3) {

  override def toString = s"ImmutableScalaClass(a=$a, b=$b, c=$c, d=$d, e=$e)"
}
