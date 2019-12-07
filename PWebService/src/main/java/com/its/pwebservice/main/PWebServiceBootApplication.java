package com.its.pwebservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author its = itshare
 *
 */
@SpringBootApplication
@ComponentScan("com.its.pwebservice.*")
@EnableAutoConfiguration
public class PWebServiceBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(PWebServiceBootApplication.class, "");
	}
}
