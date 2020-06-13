package com.curso.spring.api.controllers;

import java.util.List;

import com.curso.spring.api.models.Detalle;
import com.curso.spring.api.models.Pedido;
import com.curso.spring.api.repositories.DetalleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * DetalleController
 */
@RestController
public class DetalleController {

    @Autowired
    DetalleRepository detalleRepository;

    @GetMapping("detalles/{id}")
    public List<Detalle> getDetallePorIdPedido(@PathVariable int idPedido) {
        Pedido pedido = new Pedido();
        pedido.setId(idPedido);
        return detalleRepository.findAllByPedido(pedido);
    }
}