package com.quiniela.usuarios.models.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.quiniela.usuarios.service.IUsuarioService;
import com.quiniela.app.commons.models.entity.Usuario;

@RestController
public class UsuariosController {
	
	private final Logger logger = LoggerFactory.getLogger(UsuariosController.class);


	@Autowired
	private Environment env;
	
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/listar")
    public List<Usuario> listar(){
        return  this.usuarioService.findAll();
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
    public Usuario usuario(@PathVariable Long id){
        return usuarioService.findById(id);
    }
    
    @GetMapping("/busqueda/{user}")
    public Usuario usuario(@PathVariable("user") String userlogin){
        return usuarioService.findByUserlogin(userlogin);
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario crear(@RequestBody Usuario usuario) {
    	return this.usuarioService.save(usuario);
    }
    
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario editar(@RequestBody Usuario usuario, @PathVariable Long id){
    	Usuario usuarioE =	this.usuarioService.findById(id);
    
    usuarioE.setEmail(usuario.getEmail());
    usuarioE.setPasswd(usuario.getPasswd());
    return this.usuarioService.save(usuario);

    }
    
    @PutMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
    	this.usuarioService.deleteById(id);
        
    }
    

}
