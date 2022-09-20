package com.quinielaspringboot.eureka.springboot.servicio.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringbootServicioEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioEurekaApplication.class, args);
	}

}
