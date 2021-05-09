import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MessageDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group2");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        try(KafkaConsumer<String, Message> consumer = new KafkaConsumer<>(properties)){
            consumer.subscribe(List.of("test"));

            while(true){
                ConsumerRecords<String, Message> records = consumer.poll(Duration.ofSeconds(1));

                for (ConsumerRecord<String, Message> record : records){
                    System.out.println(record.value());
                }
            }
        }
    }
}
