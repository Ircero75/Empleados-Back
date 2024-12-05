package com.empleados.service;

import org.springframework.http.ResponseEntity;

import com.empleados.model.Response;
import com.empleados.model.entity.EmpleadoEntity;

public interface EmpleadoService {

	public ResponseEntity<Response<?>> crear(EmpleadoEntity empleado);
	public ResponseEntity<Response<?>> consultar();
	public ResponseEntity<Response<?>> editar(EmpleadoEntity empleado);
	public ResponseEntity<Response<?>> eliminar(Integer id);
	
}
