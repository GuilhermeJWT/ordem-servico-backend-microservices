package br.com.systemsgs.osservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class OsserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsserviceApplication.class, args);
	}
}
