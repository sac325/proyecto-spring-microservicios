package com.quiniela.usuarios.models.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.quiniela.app.commons.models.entity.Usuario;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	
	

	@Test
	public void testUsuario() {

		Usuario usuario = new Usuario();
		
		usuario.setId(1l);
		usuario.setUserlogin("sergio");
		usuario.setPasswd("password");
		
		assertEquals(1l, usuario.getId());
		assertEquals("sergio", usuario.getUserlogin());
		assertEquals("password", usuario.getPasswd());
	}

}
