package com.curso.spring.api.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.curso.spring.api.models.Pedido;
import com.curso.spring.api.repositories.PedidoRepository;
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
public class PedidoController {
    
    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Response<Pedido>> getPedidoPorId(@PathVariable int id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        Response<Pedido> response = new Response<>();

        if (!pedido.isPresent()) {
            response.getErrores().add("No existe el pedido");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            response.setResultado((Pedido) pedido.get());
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/pedidos")
    public List<Pedido> getPedido() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/pedidos/{fechaPedido}")
    public List<Pedido> getPedidoPorFecha(@PathVariable Date fechaPedido) {
        return pedidoRepository.findByFechaPedido(fechaPedido);        
    }

    @PostMapping("/pedidos")
    public Pedido postPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }


}