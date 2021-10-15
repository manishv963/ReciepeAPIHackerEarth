package com.hackerearth.challenge.omnicell.Reciepe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.hackerearth.challenge.omnicell.Reciepe.entities") 

public class ReciepeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReciepeApiApplication.class, args);
	}

}
