#!/usr/bin/env bash

/kafka/kafka_2.11-1.0.0/bin/zookeeper-server-start.sh config/zookeeper.properties &
/kafka/kafka_2.11-1.0.0/bin/kafka-server-start.sh config/server.properties &
/kafka/kafka_2.11-1.0.0/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic teamk

sleep infinity
