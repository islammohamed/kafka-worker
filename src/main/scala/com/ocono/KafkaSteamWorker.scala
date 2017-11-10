package com.ocono

import java.util.Properties

import org.apache.kafka.common.serialization._
import org.apache.kafka.common.utils.Bytes
import org.apache.kafka.streams._
import org.apache.kafka.streams.kstream._
import org.apache.kafka.streams.kstream.internals.PrintForeachAction
import org.apache.kafka.streams.state.KeyValueStore

import scala.collection.JavaConverters.asJavaIterableConverter


class KafkaStreamWorker {
  import KafkaStreamWorker._

  val config: Properties = {
    val p = new Properties()
    p.put(StreamsConfig.APPLICATION_ID_CONFIG, applicationName)
    p.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    p.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass)
    p.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass)
    p
  }

  val builder: StreamsBuilder = new StreamsBuilder()
  val textLines: KStream[String, String] = builder.stream(topic)
  

  val streams: KafkaStreams = new KafkaStreams(builder.build(), config)
  streams.start()
}

object KafkaStreamWorker {
  val topic:String = "teamk"
  val applicationName:String = "kafka-worker"

  def apply(kafkaClusterConfig: KafkaClusterConfig): KafkaStreamWorker = {
    new KafkaStreamWorker()
  }
}
