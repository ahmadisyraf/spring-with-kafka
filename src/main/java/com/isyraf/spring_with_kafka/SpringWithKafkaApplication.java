package com.isyraf.spring_with_kafka;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringWithKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithKafkaApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(KafkaTemplate<Integer, String> template) {
		return args -> {
			template.send("topic1",3, "Hello world from kafka");
		};
	}
}
