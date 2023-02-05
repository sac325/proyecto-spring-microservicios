package com.quiniela.usuarios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.quiniela.app.commons.models.entity.Usuario;


@FeignClient(name="springboot-servicio-usuarios")
public interface UsuarioFeignClient {
	
	@GetMapping("/servicio/search/buscar")
	public Usuario findByUserlogin(@RequestParam String userlogin);
	
//	@GetMapping("/busqueda/{user}")
//	public Usuario obtenerPorUsername(@PathVariable String user);

}
