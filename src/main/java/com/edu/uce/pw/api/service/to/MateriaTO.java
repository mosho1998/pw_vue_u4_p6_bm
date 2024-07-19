package com.edu.uce.pw.api.service.to;

import java.io.Serializable;

public class MateriaTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3826244167819812585L;
	private Integer id;
	private String nombre;
	private Integer numeroCreditos;
	public Integer getId() {
		return id;
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
	public Integer getNumeroCreditos() {
		return numeroCreditos;
	}
	public void setNumeroCreditos(Integer numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	//GET Y SET
	

	
	
}
