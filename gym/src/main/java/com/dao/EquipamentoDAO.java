package com.dao;

import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.model.Equipamento;

public class EquipamentoDAO {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public EquipamentoDAO() {
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
		
		int idEquipamento = 0;
		equipamento = em.find(Equipamento.class, idEquipamento);
		
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
	
	public List<Equipamento> listaEquipamentos(){
		TypedQuery<Equipamento> q1 = em.createQuery("SELECT * FROM equipamento", Equipamento.class);
		return (List<Equipamento>) q1;
	}
}