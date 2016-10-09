package com.kafka.producer;


import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * Created by lakshay on 18/09/16.
 * a) metadata.broker.list: specifies the broker to which Producer should send message to. Ideally two
 * brokers should be specified in case the first one fails.
 * b) serializer.class: specifies the format of the message. One can use a personal Encoder to serialize
 * the message into its own type.
 * c) partitioner.class: defines the class to identify which partition in the topic the message is to be
 * sent. If this is not provided, then producer will assign the message to random partition.
 * d) request.required.acks is used to ensure that Producer should receive an acknowledge back after message
 * has been delivered.
 *
 */
public class Publisher {

    private static Producer<String, String> producer;

    public Publisher(String broker) {
        Properties properties = new Properties();
        properties.put("metadata.broker.list", broker);
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
       //properties.put("partitioner.class", "com.kafka.producer.SimplePartitioner");
       //properties.put("request.required.acks", 1);
        ProducerConfig producerConfig = new ProducerConfig(properties);
        producer = new Producer<String, String>(producerConfig);
    }


    public static void main(String [] args) {

        String message = "Message Message Message";
        String topic = "test";
       //String partitionKey = "";
        String broker = "localhost:9092";
        Publisher publisher = new Publisher(broker);
        publisher.publishMessage(topic, message);

    }

    private void publishMessage(String topic, String message) {
        KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, message);
        producer.send(data);
        producer.close();
    }
}
