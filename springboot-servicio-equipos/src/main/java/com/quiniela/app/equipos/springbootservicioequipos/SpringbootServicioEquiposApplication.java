package com.quiniela.app.equipos.springbootservicioequipos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.quiniela.app.commons.models.entity"})
public class SpringbootServicioEquiposApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioEquiposApplication.class, args);
	}

}