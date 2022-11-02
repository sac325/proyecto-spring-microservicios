package com.quiniela.usuarios.models.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import com.quiniela.app.commons.models.entity.Usuario;

@RepositoryRestResource(path="servicio")
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
	
	@RestResource(path="/buscar")
	public Usuario findByUserlogin(@Param("userlogin") String userlogin);
	
	
	@Query("select u from Usuario u where u.userlogin=?1")
	public Usuario obtenerPorUsername(String userlogin);

}
