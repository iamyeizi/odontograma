package com.odontograma.form;

import org.apache.struts.action.ActionForm;

public class PiezaDentariaForm extends ActionForm {
	private static final long serialVersionUID = -5025587514453501667L;
	
	private int id;
    private int nroPieza;
    private String descripcion;
    private String tipoDenticion;
    private String grupoDentario;
    private String subgrupo;
    private String arcada;
    private boolean estado;
    
    
    // TODO: Think better about what things should be here
    
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
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}