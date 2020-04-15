Properties props = new Properties();
              props.put("bootstrap.servers", "localhost:9092");
              props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
              props.put("group.id", UUID.randomUUID().toString());
              props.put("consumer.timeout.ms",2000);
              props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
              props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
              KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

consumer.subscribe(Arrays.asList("topic"));
try{
while(flag){
ConsumerRecords<String, String> records = consumer.poll(1000);
            flag=false;        
for (TopicPartition partition : records.partitions()) {
List<ConsumerRecord<String, String>> partitionRecords = records.records(partition);
                           for (ConsumerRecord<String, String> record : partitionRecords) {
record.offset() 
flag=true;
}
}
counter++;
                     if(counter!=20 && !flag){
                           Thread.sleep(1000);
                     }if(counter==20){
                           break;
                     }
}
catch(){}
