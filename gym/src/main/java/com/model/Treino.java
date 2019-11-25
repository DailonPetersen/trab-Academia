package com.model;

import java.util.Calendar;

import javax.persistence.*;

@Entity
public class Treino {
	
	@Id
	@GeneratedValue
	private int id;
	
	private Calendar data;
	private String horario;
	@Transient
	private Aluno aluno;
	@Transient
	private Professor professor;
	
	public Treino() {
		
	}
	
	public Treino(Calendar data, String horario, Aluno aluno, Professor professor) {
		super();
		this.data = data;
		this.horario = horario;
		this.aluno = aluno;
		this.professor = professor;
	}
	
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}