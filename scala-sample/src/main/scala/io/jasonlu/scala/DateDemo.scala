package io.jasonlu.scala

import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date

/**
  * Created by jiehenglu on 17/01/12.
  */
object DateDemo {
  def main(args: Array[String]): Unit = {
    val dateString = "2017-01-01 01:00:01.234"
    val formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")

    val date: Date = formatter.parse(dateString)
    println(date)

    println(formatter.format(date))

    val tt: LocalTime = LocalTime.parse("12:00:00.234123")
    println(tt.getNano)
    println(tt)

  }
}
