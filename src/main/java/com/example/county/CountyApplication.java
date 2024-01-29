package com.example.county;

import com.example.county.entity.CountyDetails;
import com.example.county.service.CountyDetailsService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CountyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountyApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CountyDetailsService countyDetailsService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<CountyDetails>> typeReference = new TypeReference<List<CountyDetails>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data.json");
			try {
				List<CountyDetails> countyDetails = mapper.readValue(inputStream, typeReference);
				countyDetailsService.save(countyDetails);
				System.out.println("County Data Saved in H2 Database.");
			} catch (IOException exception) {
				System.out.println("Unable to save County Data: " + exception.getMessage());
			}
		};
	}

}
