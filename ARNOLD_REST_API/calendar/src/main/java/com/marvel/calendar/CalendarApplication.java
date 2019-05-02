package com.marvel.calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.modelmapper.ModelMapper;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Arnold Hendricks
 */


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.marvel.calendar.repository"})
@EntityScan(basePackages = {"com.marvel.calendar.entities"})
@ComponentScan(basePackages = {"com.marvel.calendar"})
public class CalendarApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CalendarApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CalendarApplication.class);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
