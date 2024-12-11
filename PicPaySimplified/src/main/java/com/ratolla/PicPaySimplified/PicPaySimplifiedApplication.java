package com.ratolla.PicPaySimplified;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PicPaySimplifiedApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicPaySimplifiedApplication.class, args);
	}

}
