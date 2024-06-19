package com.odontograma.model;

public class Odontograma {
	private int id;
    private String descripcion;
    private String tipoOdontograma;
    private Paciente paciente;
    
    public Odontograma() {}
    
	public Odontograma(int id, String descripcion, String tipoOdontograma,
			Paciente paciente) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.tipoOdontograma = tipoOdontograma;
		this.paciente = paciente;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getTipoOdontograma() {
		return tipoOdontograma;
	}



	public void setTipoOdontograma(String tipoOdontograma) {
		this.tipoOdontograma = tipoOdontograma;
	}



	public Paciente getPaciente() {
		return paciente;
	}



	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
