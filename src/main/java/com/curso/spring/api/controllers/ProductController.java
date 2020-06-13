package com.curso.spring.api.controllers;

import java.util.List;
import java.util.Optional;

import com.curso.spring.api.models.Producto;
import com.curso.spring.api.repositories.ProductoRepository;
import com.curso.spring.api.response.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @Autowired
    ProductoRepository productoRepository;

    @GetMapping("/productos/{id}")
    public ResponseEntity<Response<Producto>> getProductoPorId(@PathVariable int id){
        Optional<Producto> producto = productoRepository.findById(id);
        Response<Producto> response = new Response<>();

        if (!producto.isPresent()) {
            response.getErrores().add("No existe el elemento producto");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            response.setResultado((Producto) producto.get());
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @PostMapping("/productos")
    public Producto postProductos(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }
    
}