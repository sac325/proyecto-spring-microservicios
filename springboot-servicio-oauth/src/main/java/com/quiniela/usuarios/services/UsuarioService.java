package com.quiniela.usuarios.services;

import com.quiniela.app.commons.models.entity.Usuario;
import com.quiniela.usuarios.clients.UsuarioFeignClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService implements IUsuarioService, UserDetailsService{
	
	private Logger log = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioFeignClient client;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Usuario usuario = this.findByUsername(username);
		
		if(usuario == null) {
			log.error("Error en el login, no existe el usuario '"+username+"' en el sistema");
			throw new UsernameNotFoundException("Error en el login, no existe el usuario '"+username+"' en el sistema");
		}
		
		List<GrantedAuthority> authorities = usuario.getRole()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRolename()))
				.peek(authority -> log.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		GrantedAuthority rol = new SimpleGrantedAuthority("sysadmin");
//		authorities.add(rol);
		log.info("Usuario autenticado: " + username);
		User usuariou = new User(usuario.getUserlogin(), usuario.getPasswd(), true, true, 
				true, true, authorities);
		
		log.info("Role: " + usuariou.toString());
		return usuariou;
	}

	@Override
	public Usuario findByUsername(String username) {
		return client.findByUserlogin(username);
	}

}
