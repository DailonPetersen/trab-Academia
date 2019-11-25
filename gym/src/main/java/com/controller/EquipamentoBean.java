package com.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.model.Equipamento;

public class EquipamentoBean {
	EntityManagerFactory emf;
	EntityManager em;
	
	public EquipamentoBean() {
		
		this.emf = Persistence.createEntityManagerFactory("academia");
		this.em = this.emf.createEntityManager();
	}
	
	public void salvar(Equipamento equipamento) {
		em.getTransaction().begin();
		em.persist(equipamento);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Equipamento equipamento) {
		
		equipamento = em.find(Equipamento.class, 1);
		
		em.getTransaction().begin();
		em.remove(equipamento);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(Equipamento equipamento) {
		em.getTransaction().begin();
		em.merge(equipamento);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Equipamento> listaequipamentos(){

		TypedQuery<Equipamento> q1 = em.createQuery("SELECT * FROM equipamento", Equipamento.class);
		return (List<Equipamento>) q1;
	}

}