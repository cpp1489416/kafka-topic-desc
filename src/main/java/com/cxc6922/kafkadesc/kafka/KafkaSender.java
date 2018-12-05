package com.cxc6922.kafkadesc.kafka;

import com.cxc6922.kafkadesc.po.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
@Configuration
@EnableScheduling
@Slf4j
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Scheduled(cron = "*/4 3 * * *")
    public void send() {
        try {
            Message message = new Message();
            message.setId(new Random().nextInt());
            message.setMsg(UUID.randomUUID().toString());
            message.setInfo("just test 中国人");
            String value = objectMapper.writeValueAsString(message);
            kafkaTemplate.send("test", value);
            log.info("message sent {}", value);
        } catch (Exception e) {
            log.error("kafka 发送错误", e);
        }
    }
}
