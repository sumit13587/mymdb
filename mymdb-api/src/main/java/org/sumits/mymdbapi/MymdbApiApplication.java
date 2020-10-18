package org.sumits.mymdbapi;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.sumits.mymdbapi.repository.MovieRepository;

@SpringBootApplication
public class MymdbApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MymdbApiApplication.class, args);
	}
}
