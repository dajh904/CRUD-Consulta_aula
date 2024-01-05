package com.example.demo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Aula_Asignatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@ManyToOne
	@JoinColumn(name="Asignatura_Cod")
	private Asignatura asignatura;

	@ManyToOne
	@JoinColumn(name="Dia_ID")
	private Dia dia;

	@ManyToOne
	@JoinColumn(name="Aula_ID")
	private Aula aula;

	private String Hora_ini;
	private String Hora_fin;
	
	//Getters y Setters
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	public Dia getDia() {
		return dia;
	}
	public void setDia(Dia dia) {
		this.dia = dia;
	}
	public Aula getAula() {
		return aula;
	}
	public void setAula(Aula aula) {
		this.aula = aula;
	}
	public String getHora_ini() {
		return Hora_ini;
	}
	public void setHora_ini(String hora_ini) {
		Hora_ini = hora_ini;
	}
	public String getHora_fin() {
		return Hora_fin;
	}
	public void setHora_fin(String hora_fin) {
		Hora_fin = hora_fin;
	}
	
	//Constructores
	public Aula_Asignatura() {
		super();
	}
	
	public Aula_Asignatura(int iD, Asignatura asignatura, Dia dia, Aula aula, String hora_ini, String hora_fin) {
		ID = iD;
		this.asignatura = asignatura;
		this.dia = dia;
		this.aula = aula;
		Hora_ini = hora_ini;
		Hora_fin = hora_fin;
	}
	
}
