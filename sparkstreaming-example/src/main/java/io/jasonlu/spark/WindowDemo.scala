package io.jasonlu.spark

import kafka.serializer.StringDecoder
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * 场景：计算时间窗内累计次数
 *
 * Created by Louz on 2016/5/17.
 */
object WindowDemo {
  def main(args: Array[String]) {
//    val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
    val conf = new SparkConf().setAppName("NetworkWordCount")

    // every 10 second produce a batch
    val ssc = new StreamingContext(conf, Seconds(10))

    // window operation must set checkpoint
    ssc.checkpoint("/tmp/tmp")

    val kafkaProp = Map[String, String](
      "bootstrap.servers" -> "kafka:9092",
      "acks" -> "all",
      "retries" -> "0",
      "batch.size" -> "16384",
      "linger.ms" -> "1",
      "buffer.memory" -> "33554432"
//      "key.serializer" -> "org.apache.kafka.common.serialization.StringSerializer",
//      "value.serializer" -> "org.apache.kafka.common.serialization.StringSerializer"
    )

    val topics = Set("test")
    val directKafkaStream = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](ssc, kafkaProp, topics)

//    val lines = ssc.socketTextStream("localhost", 9999)

//    val words = lines.flatMap(_.split(" "))
    val words = directKafkaStream.flatMapValues(_.split(" "))

    val wordCount = words.countByValueAndWindow(Seconds(30), Seconds(20))
    wordCount.print()

    ssc.start()             // Start the computation
    ssc.awaitTermination()  // Wait for the computation to terminate
  }
}
