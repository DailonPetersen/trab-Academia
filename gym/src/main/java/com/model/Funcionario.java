package com.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue
	private int id;
	
	private Date iniciouEm;
	private String nome;
	private String telefone;
	private double salario;
	private String turno;
	private String funcao;

	public Funcionario() {
		super();

	}
	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public Date getIniciouEm() {
		return iniciouEm;
	}
	public void setIniciouEm(Date iniciouEm) {
		this.iniciouEm = iniciouEm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
}
