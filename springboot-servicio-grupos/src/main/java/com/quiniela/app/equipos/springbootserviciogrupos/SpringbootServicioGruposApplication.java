package com.quiniela.app.equipos.springbootserviciogrupos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EntityScan({"com.quiniela.app.commons.models.entity"})
public class SpringbootServicioGruposApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioGruposApplication.class, args);
	}

}
