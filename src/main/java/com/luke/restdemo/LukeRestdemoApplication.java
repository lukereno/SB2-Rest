package com.luke.restdemo;

import com.luke.config.SharedAutoConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(SharedAutoConfiguration.class)
public class LukeRestdemoApplication extends SpringBootServletInitializer {

    private static final Logger logger = LogManager.getLogger(LukeRestdemoApplication.class);


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
