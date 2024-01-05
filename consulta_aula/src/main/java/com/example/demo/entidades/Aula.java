package com.example.demo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Aula {
	@Id private String ID;
	private int Piso;
	private String Tipo;
	
	//Getters y setters
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getPiso() {
		return Piso;
	}
	public void setPiso(int piso) {
		Piso = piso;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	//Constructores
	public Aula(String iD, int piso, String tipo) {
		super();
		ID = iD;
		Piso = piso;
		Tipo = tipo;
	}
	public Aula() {
		super();
	}
}
