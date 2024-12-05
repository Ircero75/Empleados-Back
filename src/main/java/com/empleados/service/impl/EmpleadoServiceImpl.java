package com.empleados.service.impl;

import java.sql.SQLException;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.empleados.model.Response;
import com.empleados.model.dao.EmpleadoDao;
import com.empleados.model.entity.EmpleadoEntity;
import com.empleados.service.EmpleadoService;

@Transactional(rollbackOn = SQLException.class)
@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoDao empleadoDao;
	
	private static final String EXITO = "Proceso Exitoso";
	private static final String FALLO = "Proceso Fallo";
	
	private static final Logger log = LoggerFactory.getLogger(EmpleadoServiceImpl.class);

	@Override
	public ResponseEntity<Response<?>> crear(EmpleadoEntity empleado) {
		
		ResponseEntity<Response<?>> responseEntity;
		Response<Object> response = new Response<>();
		
		try {
			
			log.info("Creando Empleado");
			
			empleado.setFechaAlta( Calendar.getInstance().getTime() );
			empleado.setActivo(true);
			empleadoDao.save(empleado);
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(1);
			response.setMessage(EXITO);
			response.setInfo(empleado);
			
			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
			
		}catch (Exception e) {
			
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(FALLO);
			response.setInfo(e.getMessage());
			
			responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		return responseEntity;
	
	}

	@Override
	public ResponseEntity<Response<?>> consultar() {
		
		ResponseEntity<Response<?>> responseEntity;
		Response<Object> response = new Response<>();
		
		try {
			
			log.info("Consultando Empleados");
			
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(1);
			response.setMessage(EXITO);
			response.setInfo(empleadoDao.consulta());
			
			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
			
		}catch (Exception e) {
			
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(FALLO);
			response.setInfo(e.getMessage());
			
			responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		return responseEntity;
	}

	@Override
	public ResponseEntity<Response<?>> editar(EmpleadoEntity empleado) {
		
		ResponseEntity<Response<?>> responseEntity;
		Response<Object> response = new Response<>();
		
		try {
			
			log.info("Editando Empleado");
			
			empleado.setFechaActualizacion( Calendar.getInstance().getTime() );
			empleadoDao.save(empleado);
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(1);
			response.setMessage(EXITO);
			response.setInfo(empleado);
			
			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
			
		}catch (Exception e) {
			
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(FALLO);
			response.setInfo(e.getMessage());
			
			responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		return responseEntity;
		
	}

	@Override
	public ResponseEntity<Response<?>> eliminar(Integer id) {
		
		ResponseEntity<Response<?>> responseEntity;
		Response<Object> response = new Response<>();
		
		try {
			
			log.info("Eliminando Empleado");
			
			empleadoDao.eliminar(id);
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(1);
			response.setMessage(EXITO);
			
			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
			
		}catch (Exception e) {
			
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(FALLO);
			response.setInfo(e.getMessage());
			
			responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		return responseEntity;
	}

}
