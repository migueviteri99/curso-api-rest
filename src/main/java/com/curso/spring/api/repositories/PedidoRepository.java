package com.curso.spring.api.repositories;

import java.util.Date;
import java.util.List;

import com.curso.spring.api.models.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByFechaPedido(Date fechaPedido);
    
}