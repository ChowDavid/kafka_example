package com.david.kafka.producer;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.LocalDateTime;
import java.util.Properties;

public class KafkaSimpleProducer {
    public static void main(String[] args) {
        System.out.println("Hello Kafka");
        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        //Create the producer
        final KafkaProducer<String ,String> kp = new KafkaProducer<String, String>(prop);
        for(int i=0;i<100;i++) {
            //create the producer record
            ProducerRecord<String, String> record = new ProducerRecord<>("sample-topic", "Key1", LocalDateTime.now().toString());
            kp.send(record);
        }
        //Send data - Async
        kp.send(new ProducerRecord<>("sample-topic", "Key1", "end"));

        kp.flush();
        kp.close();
    }
}
