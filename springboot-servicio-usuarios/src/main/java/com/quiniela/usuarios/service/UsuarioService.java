package com.quiniela.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quiniela.usuarios.models.dao.UsuarioDao;
import com.quiniela.app.commons.models.entity.Usuario;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	UsuarioDao usuariosDao;

	@Override
    @Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return this.usuariosDao.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return this.usuariosDao.findById(id).get();
	}

	@Override
	public Usuario save(Usuario usuario) {
		return this.usuariosDao.save(usuario);
	}

	@Override
	public void deleteById(Long id) {
		this.usuariosDao.deleteById(id);
		
	}

	@Override
	public Usuario findByUserlogin(String userlogin) {
		return this.usuariosDao.obtenerPorUsername(userlogin);
	}

}
