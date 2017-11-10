package com.ocono

class KafkaStreamWorker {

}

object KafkaStreamWorker {

  def apply(kafkaClusterConfig: KafkaClusterConfig): KafkaStreamWorker = {
    new KafkaStreamWorker()
  }
}
