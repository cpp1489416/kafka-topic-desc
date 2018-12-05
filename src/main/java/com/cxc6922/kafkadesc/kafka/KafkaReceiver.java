package com.cxc6922.kafkadesc.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaReceiver {
    @KafkaListener(topics={"test"})
    public void listen(ConsumerRecord<?,?> record) {
        Object value = record.value();
        log.info("message received: ====================+ {}" + value);
    }
}
