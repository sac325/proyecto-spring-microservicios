package com.quiniela.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EntityScan({"com.quiniela.app.commons.models.entity"})
public class SpringbootServicioOauthApplication implements CommandLineRunner{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioOauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String passwdString = "12345";
		
		for (int i = 0; i < 4; i++) {
			String passwordBCryoptString = passwordEncoder.encode(passwdString);
			System.out.println(passwordBCryoptString);
		}
		
	}

}
