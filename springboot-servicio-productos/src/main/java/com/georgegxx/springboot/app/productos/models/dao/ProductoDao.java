package com.georgegxx.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

//import com.georgegxx.springboot.app.commons.models.entity.Producto;
import com.georgegxx.springboot.app.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{

}