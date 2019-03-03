package com.luke.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LukeRestdemoApplication extends SpringBootServletInitializer {

//	public static void main(String[] args) {
//		SpringApplication.run(LukeRestdemoApplication.class, args);
//	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LukeRestdemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LukeRestdemoApplication.class, args);
	}

}
