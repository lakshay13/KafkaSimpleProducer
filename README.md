# KafkaSimpleProducer
A very simple Kafka Producer that shows how to send messages to a particular topic. In order to run this code, following things would be required

Step 1. Start the zookeeper

zkServer start

Step 2. Start the kafka server

kafka-server-start /usr/local/etc/kafka/server.properties

Step 3. Since we have not implemented a consumer as of now so we can start the consumer like:

kafka-console-consumer.sh --zookeeper localhost:2181 --topic test --from-beginning

Note: 2181 is the default port,
topic "test" is the topic name where producer will send messages and from where consumer will consume.

For any further information: visit https://lakshaysuri.wordpress.com/blog/