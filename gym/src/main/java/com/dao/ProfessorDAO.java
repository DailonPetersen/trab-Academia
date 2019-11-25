package com.dao;

import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.model.Professor;

public class ProfessorDAO {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public ProfessorDAO() {
		this.emf = Persistence.createEntityManagerFactory("academia");
		this.em = this.emf.createEntityManager();
	}
	
	public void salvar(Professor professor) {
		em.getTransaction().begin();
		em.persist(professor);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Professor professor) {
		
		int idProfessor = 0;
		professor = em.find(Professor.class, idProfessor);
		
		em.getTransaction().begin();
		em.remove(professor);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(Professor professor) {
		em.getTransaction().begin();
		em.merge(professor);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Professor> listaProfessors(){
		TypedQuery<Professor> q1 = em.createQuery("SELECT * FROM professor", Professor.class);
		return (List<Professor>) q1;
	}
}