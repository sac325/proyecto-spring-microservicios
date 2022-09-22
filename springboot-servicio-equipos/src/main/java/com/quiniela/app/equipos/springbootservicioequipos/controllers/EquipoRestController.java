package com.quiniela.app.equipos.springbootservicioequipos.controllers;

import com.quiniela.app.commons.models.entity.Equipo;
import com.quiniela.app.equipos.springbootservicioequipos.services.IEquipoService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EquipoRestController {
private final Logger logger = LoggerFactory.getLogger(EquipoRestController.class);


	@Autowired
	private Environment env;
	
    @Autowired
    private CircuitBreakerFactory cbFactory;

    @Autowired
    private IEquipoService equipoService;

    @GetMapping("/listar")
    public List<Equipo> listar(){
        return  equipoService.findAll();
    }

    @GetMapping("/config")
    public ResponseEntity<?> config(@Value("${server.port}") String puerto){
    	
    	Map<String, String> json= new HashMap<>();
    	json.put("puerto", puerto);
    	
    	if(env.getActiveProfiles().length > 0 && env.getActiveProfiles().equals("env")) {
    		json.put("entorno", env.getProperty("configuracion.autor.nombre"));
    		json.put("entorno", env.getProperty("configuracion.autor.email"));
    	}
    	
        return  new ResponseEntity<Map<String,String>>(json,HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public Equipo equipo(@PathVariable Long id){
        return cbFactory.create("equipos").run(()->equipoService.findById(id), e -> metodoFullAlternatvo(id,e));
    }

    public Equipo metodoFullAlternatvo(Long id, Throwable e){
        logger.info(e.getMessage());
        return new Equipo();
    }
    
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo crear(@RequestBody Equipo equipo) {
    	return equipoService.save(equipo);
    }
    
    
    @PutMapping("/editar/{id}"){
    	
    }
    
    
    
}
