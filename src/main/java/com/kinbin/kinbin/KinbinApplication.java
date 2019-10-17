package com.kinbin.kinbin;

import com.kinbin.kinbin.configuration.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class KinbinApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinbinApplication.class, args);
	}

}
