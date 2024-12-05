package com.empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.model.Response;
import com.empleados.model.entity.EmpleadoEntity;
import com.empleados.service.EmpleadoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping (value="/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@PostMapping
	public ResponseEntity<Response<?>> crear(@RequestBody EmpleadoEntity empleado) {
		return empleadoService.crear(empleado);
	}
	
	
	@GetMapping
	public ResponseEntity<Response<?>> consultar() {
		return empleadoService.consultar();
	}
	
	@PutMapping
	public ResponseEntity<Response<?>> editar(@RequestBody EmpleadoEntity empleado) {
		return empleadoService.editar(empleado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<?>> eliminar(@PathVariable Integer id) {
		return empleadoService.eliminar(id);
	}
}
