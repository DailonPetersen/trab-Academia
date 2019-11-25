package com.dao;

import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.model.Aluno;

public class AlunoDAO {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public AlunoDAO() {
		this.emf = Persistence.createEntityManagerFactory("academia");
		this.em = this.emf.createEntityManager();
	}
	
	public void salvar(Aluno aluno) {
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Aluno aluno) {
		
		int idAluno = 0;
		aluno = em.find(Aluno.class, idAluno);
		
		em.getTransaction().begin();
		em.remove(aluno);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(Aluno aluno) {
		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Aluno> listaAlunos(){
		TypedQuery<Aluno> q1 = em.createQuery("SELECT * FROM aluno", Aluno.class);
		return (List<Aluno>) q1;
	}
}
