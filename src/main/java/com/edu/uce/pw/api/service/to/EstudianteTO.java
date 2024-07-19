package com.edu.uce.pw.api.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.boot.jaxb.hbm.internal.RepresentationModeConverter;
import org.springframework.hateoas.RepresentationModel;

import com.edu.uce.pw.api.repository.modelo.Materia;

import jakarta.persistence.OneToMany;

public class EstudianteTO extends RepresentationModel implements Serializable {

	private static final long serialVersionUID = 7522247553314511578L;

	private Integer id;
	private String nombre;
	private String apellido;
	private LocalDateTime fechaNacimiento;
	private String genero;
	private Integer cedula;

	@OneToMany(mappedBy = "estudiante")
	//private List<MateriaTO> materias;
	

	
	
	// GET Y SET

//	public List<MateriaTO> getMaterias() {
//		return materias;
//	}
//
//	public void setMaterias(List<MateriaTO> materias) {
//		this.materias = materias;
//	}
//SET Y GET
	public Integer getId() {
		return id;
	}

	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
