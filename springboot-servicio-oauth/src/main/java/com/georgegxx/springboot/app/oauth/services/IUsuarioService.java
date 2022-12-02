package com.georgegxx.springboot.app.oauth.services;

import com.georgegxx.springboot.app.oauth.usuarios.models.entity.Usuario;
//import com.georgegxx.springboot.app.commons.usuarios.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);
	
	public Usuario update(Usuario usuario, Long id);

}
