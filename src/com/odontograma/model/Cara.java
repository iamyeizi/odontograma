package com.odontograma.model;

public class Cara {
	private int id;
    private String detalle;
    private String tipo;
    

    public Cara() {}
    
	public Cara(int id, String detalle, String tipo) {
		super();
		this.id = id;
		this.detalle = detalle;
		this.tipo = tipo;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
