package com.odontograma.model;

import java.sql.Date;

public class Paciente {
	private int id;
    private int nroDoc;
    private String tipoDoc;
    private String nombre;
    private String apellido;
    private java.sql.Date fechaNacimiento;
    private String genero;
    private String domicilio;
    private String email;
    private String telefono;
    
    
    public Paciente() {}
    
    
	public Paciente(int id, int nroDoc, String tipoDoc, String nombre,
			String apellido, Date fechaNacimiento, String genero,
			String domicilio, String email, String telefono) {
		super();
		this.id = id;
		this.nroDoc = nroDoc;
		this.tipoDoc = tipoDoc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.domicilio = domicilio;
		this.email = email;
		this.telefono = telefono;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNroDoc() {
		return nroDoc;
	}


	public void setNroDoc(int nroDoc) {
		this.nroDoc = nroDoc;
	}


	public String getTipoDoc() {
		return tipoDoc;
	}


	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
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


	public java.sql.Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(java.sql.Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}    
}
