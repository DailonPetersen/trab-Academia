package com.dao;

import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.model.Treino;

public class TreinoDAO {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public TreinoDAO() {
		this.emf = Persistence.createEntityManagerFactory("academia");
		this.em = this.emf.createEntityManager();
	}
	
	public void salvar(Treino treino) {
		em.getTransaction().begin();
		em.persist(treino);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Treino treino) {
		
		int idTreino = 0;
		treino = em.find(Treino.class, idTreino);
		
		em.getTransaction().begin();
		em.remove(treino);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(Treino treino) {
		em.getTransaction().begin();
		em.merge(treino);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Treino> listaTreinos(){
		TypedQuery<Treino> q1 = em.createQuery("SELECT * FROM treino", Treino.class);
		return (List<Treino>) q1;
	}
}