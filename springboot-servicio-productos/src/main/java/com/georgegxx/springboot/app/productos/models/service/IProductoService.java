package com.georgegxx.springboot.app.productos.models.service;

import java.util.List;

//import com.georgegxx.springboot.app.commons.models.entity.Producto;
import com.georgegxx.springboot.app.productos.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id);
	public Producto save(Producto producto);
	public void deleteById(Long id);
}
