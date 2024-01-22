package tb.kafkaexample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "tb", groupId = "groupId", containerFactory = "containerFactory")
    void listenToKafkaTBTopic(Message msg) {
        System.out.println("received: "+msg);
    }
}
