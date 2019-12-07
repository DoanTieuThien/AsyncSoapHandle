package com.its.webservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author its = itshare
 *
 */
@SpringBootApplication
@ComponentScan("com.its.webservice.*")
@EnableAutoConfiguration
public class VWebServiceBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(VWebServiceBootApplication.class, "");
	}
}
