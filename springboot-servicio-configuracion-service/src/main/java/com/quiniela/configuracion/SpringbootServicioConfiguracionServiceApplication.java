package com.quiniela.configuracion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringbootServicioConfiguracionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioConfiguracionServiceApplication.class, args);
	}

}
