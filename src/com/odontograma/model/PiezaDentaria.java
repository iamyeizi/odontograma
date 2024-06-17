package com.odontograma.model;

public class PiezaDentaria {
    private int id;
    private int nroPieza;
    private String descripcion;
    private String tipoDenticion;
    private String grupoDentario;
    private String subgrupo;
    private String arcada;
    private Boolean estado;
    
	// TODO: Review if it need to have to a toString override
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNroPieza() {
		return nroPieza;
	}
	public void setNroPieza(int nroPieza) {
		this.nroPieza = nroPieza;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoDenticion() {
		return tipoDenticion;
	}
	public void setTipoDenticion(String tipoDenticion) {
		this.tipoDenticion = tipoDenticion;
	}
	public String getGrupoDentario() {
		return grupoDentario;
	}
	public void setGrupoDentario(String grupoDentario) {
		this.grupoDentario = grupoDentario;
	}
	public String getSubgrupo() {
		return subgrupo;
	}
	public void setSubgrupo(String subgrupo) {
		this.subgrupo = subgrupo;
	}
	public String getArcada() {
		return arcada;
	}
	public void setArcada(String arcada) {
		this.arcada = arcada;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
