package com.mitocode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.mitocode.dao.IUsuarioDAO;
import com.mitocode.model.Usuario;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MediappBackendApplicationTests {

	@Autowired
	private IUsuarioDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Test
	public void crearUsuario() {
		Usuario us = new Usuario();
		us.setIdUsuario(4);
		us.setUsername("code");
		us.setPassword(bcrypt.encode("123"));
		us.setEnabled(true);
		
		Usuario retorno = dao.save(us);
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
