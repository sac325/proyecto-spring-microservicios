package com.quiniela.app.equipos.springbootservicioequipos.controllers;

import com.quiniela.app.commons.models.entity.Equipo;
import com.quiniela.app.equipos.springbootservicioequipos.services.IEquipoService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    // create listar pageable
    @GetMapping("/listar/page/{page}")
    public Page<Equipo> listar(@PathVariable Integer page){
        return  equipoService.findAll(PageRequest.of(page, 4));
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

   /*  @GetMapping("/listar/{id}")
    public Equipo equipo(@PathVariable Long id){
        return cbFactory.create("equipos").run(()->equipoService.findById(id), e -> metodoFullAlternatvo(id,e));
    } */

    // create listar por id con circuit breaker return response entity validate Equipo 
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> equipo(@PathVariable Long id){
        //call methos full alternativo if error in findById method recieve resonse entity with error message in json format
        
        Equipo equipo = cbFactory.create("equipos").run(()->equipoService.findById(id), e -> metodoFullAlternatvo(id,e));
        if(equipo == null || equipo.getNombre() == null){
            Map<String, String> json= new HashMap<>();
            json.put("mensaje", "El equipo no existe en la base de datos");
            json.put("error", "Error en el servidor");
            return new ResponseEntity<Map<String,String>>(json,HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(equipo);
    }

     public Equipo metodoFullAlternatvo(Long id, Throwable e){
        logger.info(e.getMessage());
        return new Equipo();
    } 

    // create metodoFullAlternatvo return response entity with error message in json format
   /*  public ResponseEntity<?> metodoFullAlternatvo(Long id, Throwable e){
        logger.info(e.getMessage());
        Map<String, String> json= new HashMap<>();
        json.put("mensaje", "Error en el servidor");
        json.put("error", e.getMessage());
        return new ResponseEntity<Map<String,String>>(json,HttpStatus.NOT_FOUND);
    } */
    
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo crear(@RequestBody Equipo equipo) {
    	return equipoService.save(equipo);
    }
    
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo editar(@RequestBody Equipo equipo, @PathVariable Long id){
    Equipo equipoE =	equipoService.findById(id);
    
    equipoE.setNombre(equipo.getNombre());
    equipoE.setImageSize(equipo.getImageSize());
    equipoE.setImageData(equipo.getImageData());
    equipoE.setFilename(equipo.getFilename());
    equipoE.setContentType(equipo.getContentType());
    return equipoService.save(equipo);

    }
    
    @PutMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
    	equipoService.deleteById(id);
        
    }
    
    
    
}
