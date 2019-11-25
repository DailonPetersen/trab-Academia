package com.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Professor extends Funcionario{
	
	private int idProfessor;
	private boolean formado;
	
	public Professor() {
		super();

	}

	public int getId() {
		return idProfessor;
	}

	public void setId(int id) {
		this.idProfessor = id;
	}

	public boolean isFormado() {
		return formado;
	}

	public void setFormado(boolean formado) {
		this.formado = formado;
	}
	
	
	
}
