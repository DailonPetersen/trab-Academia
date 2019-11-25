package com.model;

import java.util.Calendar;

import javax.persistence.*;

@Entity
public class Equipamento {
	
	@Id
	@GeneratedValue
	private int Id;
	
	private String nome;
	private double preco;
	private Calendar compradoEm;
	private String marca;
	private String peso;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Calendar getCompradoEm() {
		return compradoEm;
	}
	public void setCompradoEm(Calendar compradoEm) {
		this.compradoEm = compradoEm;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
}

