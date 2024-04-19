package com.crudejemplo.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crudejemplo.demo.Models.Producto;

@Repository
public interface ProductRepository extends CrudRepository<Producto,Integer> {

}
