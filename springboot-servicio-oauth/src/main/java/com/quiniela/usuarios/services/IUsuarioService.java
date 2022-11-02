package com.quiniela.usuarios.services;

import com.quiniela.app.commons.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);

}
