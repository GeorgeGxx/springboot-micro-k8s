package com.georgegxx.springboot.app.usuarios;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.georgegxx.springboot.app.usuarios.models.entity.Role;
import com.georgegxx.springboot.app.usuarios.models.entity.Usuario;

//import com.georgegxx.springboot.app.commons.usuarios.models.entity.Role;
//import com.georgegxx.springboot.app.commons.usuarios.models.entity.Usuario;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		config.exposeIdsFor(Usuario.class, Role.class);
	}

	
}
