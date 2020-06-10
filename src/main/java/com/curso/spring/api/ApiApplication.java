package com.curso.spring.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

		/*Producto producto = new Producto();
		producto.setDescripcion("Lapices");
		producto.setPrecio(1.12);
		producto.setStock(23);

		System.out.println(producto);*/
	}

}
