package com.empleados.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empleados.model.entity.EmpleadoEntity;

@Repository
public interface EmpleadoDao extends CrudRepository<EmpleadoEntity, Integer> {

	@Query(value = "SELECT * FROM EMPLEADOS",  nativeQuery = true)
	List<EmpleadoEntity> consulta();
	
	@Modifying(flushAutomatically = false)
	@Query(value = ""
			+ " UPDATE EMPLEADOS "
			+ " SET	"
			+ " FEC_BAJA = CURRENT_TIMESTAMP(), "
			+ " IND_ACTIVO = 0 "
			+ " WHERE "
			+ " ID_EMPLEADO = ? "
			,nativeQuery = true )
	void eliminar(Integer id);
}
