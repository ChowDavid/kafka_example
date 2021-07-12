package com.david.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;


public class MyCallBack implements Callback {
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if (e!=null){
            System.err.println("Error "+e.getMessage());
        } else {
            System.out.println("Callback done for topics "+recordMetadata.topic()+" at "+ LocalDateTime.ofInstant(Instant.ofEpochMilli(recordMetadata.timestamp()), TimeZone.getDefault().toZoneId()));
        }


    }
}
