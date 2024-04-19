package com.crudejemplo.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crudejemplo.demo.Models.Producto;
import com.crudejemplo.demo.Services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Producto> allList() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<?> findById(@PathVariable(value = "id") Integer id) {
        return productService.findProduct(id);
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto create(@RequestBody Producto producto) {
     return productService.save(producto);   
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto update(@RequestBody Producto producto) {
     return productService.update(producto);   
    }
}
