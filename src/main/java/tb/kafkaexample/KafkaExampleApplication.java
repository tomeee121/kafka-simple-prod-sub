package tb.kafkaexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class KafkaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaExampleApplication.class, args);
    }


    @Bean
    public CommandLineRunner runner(KafkaTemplate<String, Message> kafkaTemplate) {
        return args -> {
            for (int i = 0; i < 100; i++) {
                kafkaTemplate.send("tb", new Message(i + "hello kafka", LocalDateTime.now()));
            }
        };
    }
}
