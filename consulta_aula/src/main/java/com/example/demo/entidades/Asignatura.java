package com.example.demo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Asignatura {

	@Id
	private int Cod;
	private String Nombre;
	private int Semestre;

	@ManyToOne
	@JoinColumn(name="Docente_ID")
	private Docente docente;

	@ManyToOne
	@JoinColumn(name="Programa_ID")
	private Programa programa;

	//Getters y Setters
	public int getCod() {
		return Cod;
	}
	public void setCod(int Cod) {
		this.Cod = Cod;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	public int getSemestre() {
		return Semestre;
	}
	public void setSemestre(int Semestre) {
		this.Semestre = Semestre;
	}

	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public Programa getPrograma() {
		return programa;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	//Constructores
	public Asignatura() {
		super();
	}

	public Asignatura(int cod, String nombre, int semestre, Docente docente, Programa programa) {
		Cod = cod;
		Nombre = nombre;
		Semestre = semestre;
		this.docente = docente;
		this.programa = programa;
	}
}
