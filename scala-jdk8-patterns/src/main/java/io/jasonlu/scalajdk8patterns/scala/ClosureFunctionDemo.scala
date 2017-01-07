package io.jasonlu.scalajdk8patterns.scala

/**
  * Created by louz on 2016/10/9.
  */
object ClosureFunctionDemo {
  def makeClosureFunction(x: Int, func: Int => String) = {
    i: Int => func(x * i)
  }

  def baseFunction(i: Int): String = {
    "This is string: " + i
  }

  def main(args: Array[String]): Unit = {
    // 调用makeClosureFunction时，可以理解成将100和baseFunction两个参数作为closureFunction的成员变量存放起来
    val closureFunction = makeClosureFunction(100, baseFunction)

    // 调用closureFunction(10)时，利用成员变量100和baseFunction以及入参10进行计算，返回结果
    print(closureFunction(10))
  }
}
