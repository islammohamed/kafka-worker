package com.ocono


object Worker extends App {
  val kafkaClusterConfig = KafkaClusterConfig()

  val KafkaWorker = KafkaStreamWorker(kafkaClusterConfig)

}
