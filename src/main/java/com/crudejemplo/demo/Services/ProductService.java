package com.crudejemplo.demo.Services;

import java.util.List;
import java.util.Optional;

import com.crudejemplo.demo.Models.Producto;


public interface ProductService {

    Producto save(Producto producto);  
    List<Producto> findAllProducts();
    void deleteProduct(int id);
    Optional<?> findProduct(int id);
    Producto update(Producto producto);
}
