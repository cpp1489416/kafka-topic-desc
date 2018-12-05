package com.cxc6922.kafkadesc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class KafkaDescApplication {

    public static void main(String[] args) {

        SpringApplication.run(KafkaDescApplication.class, args);
    }

}
