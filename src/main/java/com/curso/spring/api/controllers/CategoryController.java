package com.curso.spring.api.controllers;

import java.util.List;
import java.util.Optional;

import com.curso.spring.api.models.Categoria;
import com.curso.spring.api.repositories.CategoriaRepository;
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
public class CategoryController {

    @Autowired
    CategoriaRepository categoriaRepository;
    
    @GetMapping("/saludar/{nombre}")
    public String saludar(@PathVariable String nombre) {
        return "HOLA " + nombre;
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<Response<Categoria>> getCategoriaPorId(@PathVariable int id) {
        Optional categoria = categoriaRepository.findById(id);
        Response<Categoria> response = new Response<>();

        if (!categoria.isPresent()) {
            response.getErrores().add("No existe el elemento");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            response.setResultado((Categoria)categoria.get());
            return ResponseEntity.ok(response);
        }        
    }

    @GetMapping("/categorias")                      
    public List<Categoria> getCategoria() {
        return categoriaRepository.findAll(); 
    }
    
    @PostMapping("/categorias")
    public Categoria postCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}