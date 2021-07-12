# Start Kafla server
```
kafka-server-start.sh config/server.properties
```

# Create Kafka Topics
```
kafka-topics.sh --bootstrap-server localhost:9092 --topic sample-topic --create --partitions 3
```

# Create Kafka Consumer
```aidl
kafka-console-consumer.sh --topic sample-topic --from-beginning -bootstrap-server localhost:9092
```