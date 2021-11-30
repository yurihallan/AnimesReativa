package com.digitalinnovationone.Animesapi;


import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableDynamoDBRepositories
public class AnimesapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimesapiApplication.class, args);
		System.out.println("Better Animes with webflux");
	}

}
