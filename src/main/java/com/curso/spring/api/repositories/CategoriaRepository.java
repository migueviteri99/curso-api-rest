package com.curso.spring.api.repositories;

import com.curso.spring.api.models.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Categoria findByDescripcion(String descripcion);

    @Query("Select c from Categoria c where c.descripcion = ?1")
    Categoria getByDescripcion(String descripcion);
    
}