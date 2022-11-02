package com.quiniela.usuarios.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import com.quiniela.app.commons.models.entity.Usuario;


public interface IUsuarioService   {

	    List<Usuario> findAll();

	    Usuario findById(Long id);
	    
	    Usuario save(Usuario equipo);
	    
	    void deleteById(Long id);
	    
	    public Usuario findByUserlogin(String userlogin);
	}
