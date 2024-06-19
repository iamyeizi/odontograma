package com.odontograma.model;

public class PiezaDentaria {
    private int id;
    private int nroPieza;
    private String detalle;
    private String tipoDenticion;
    private String grupoDentario;
    private String subgrupo;
    private String arcada;
    private boolean estado;
  
    
	public PiezaDentaria(int id, int nroPieza, String detalle,
			String tipoDenticion, String grupoDentario, String subgrupo,
			String arcada, boolean estado) {
		super();
		this.id = id;
		this.nroPieza = nroPieza;
		this.detalle = detalle;
		this.tipoDenticion = tipoDenticion;
		this.grupoDentario = grupoDentario;
		this.subgrupo = subgrupo;
		this.arcada = arcada;
		this.estado = estado;
	}
	
	
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
	public String getDetalle() {
		return detalle;
	}
	public void setDescripcion(String detalle) {
		this.detalle = detalle;
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
	public boolean getEstado() {
		return estado;
	}
	public boolean setEstado(boolean estado) {
		return this.estado = estado;
	}
}
