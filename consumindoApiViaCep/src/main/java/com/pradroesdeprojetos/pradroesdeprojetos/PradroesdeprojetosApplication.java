package com.pradroesdeprojetos.pradroesdeprojetos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PradroesdeprojetosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PradroesdeprojetosApplication.class, args);
	}

}
