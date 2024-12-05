package com.empleados.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="EMPLEADOS")
public class EmpleadoEntity implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_EMPLEADO")
	private Integer id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="APELLIDO_PATERNO")
	private String apellidoPaterno;
	
	@Column(name="APELLIDO_MATERNO")
	private String apellidoMaterno;
	
	@Column(name="CURP")
	private String curp;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="SEXO")
	private String sexo;
	
	@Column(name="IND_ACTIVO")
	private Boolean activo;
	
	@Column(name="FEC_ALTA")
	private Date fechaAlta;
	
	@Column(name="FEC_BAJA")
	private Date fechaBaja;
	
	@Column(name="FEC_ACTUALIZACION")
	private Date fechaActualizacion;
}
