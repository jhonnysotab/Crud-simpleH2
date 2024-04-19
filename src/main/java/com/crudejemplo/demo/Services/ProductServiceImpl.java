package com.crudejemplo.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudejemplo.demo.Models.Producto;
import com.crudejemplo.demo.Repositories.ProductRepository;

@Service
public class ProductServiceImpl  implements ProductService{

    @Autowired
     private ProductRepository productRepository;
    @Override
    public Producto save(Producto producto) {
    
        return productRepository.save(producto);
    
    }

    @Override
    public List<Producto> findAllProducts() {
      return (List<Producto>)productRepository.findAll();
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<?> findProduct(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Producto update( Producto producto) {
        Optional<Producto> product = productRepository.findById(producto.getId());
        if(product.isPresent()){
            Producto p = product.get();
            p.setDescription(producto.getDescription());
            p.setPrice(producto.getPrice());
            p.setName(producto.getName());
            return productRepository.save(p);
        }
        return null;
        
    }

}
