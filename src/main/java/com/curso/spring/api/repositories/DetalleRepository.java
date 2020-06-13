package com.curso.spring.api.repositories;

import java.util.List;

import com.curso.spring.api.models.Detalle;
import com.curso.spring.api.models.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleRepository extends JpaRepository<Detalle, Integer>{

    List<Detalle> findAllByPedido(Pedido pedido);
    
}