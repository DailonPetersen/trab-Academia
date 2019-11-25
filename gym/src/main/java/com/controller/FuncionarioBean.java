package com.controller;

import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.model.Funcionario;

public class FuncionarioBean {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public FuncionarioBean() {
		this.emf = Persistence.createEntityManagerFactory("academia");
		this.em = this.emf.createEntityManager();
	}
	
	public void salvar(Funcionario funcionario) {
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Funcionario funcionario) {
		
		int idFuncionario = 0;
		funcionario = em.find(Funcionario.class, idFuncionario);
		
		em.getTransaction().begin();
		em.remove(funcionario);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(Funcionario funcionario) {
		em.getTransaction().begin();
		em.merge(funcionario);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Funcionario> listaFuncionarios(){
		TypedQuery<Funcionario> q1 = em.createQuery("SELECT * FROM funcionario", Funcionario.class);
		return (List<Funcionario>) q1;
	}
}