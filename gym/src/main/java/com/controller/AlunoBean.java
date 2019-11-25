package com.controller;

import java.util.List;
import java.util.Set;

import javax.faces.bean.*;
import javax.faces.event.NamedEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.model.Aluno;
import com.dao.AlunoDAO;

@ManagedBean(name="AlunoBean")
@NamedEvent
public class AlunoBean extends Aluno{

	
	EntityManagerFactory emf;
	EntityManager em;
	
	public AlunoBean() {
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
		
		int idAluno = 321312;
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
	
	public Aluno buscarAluno() {
		return this.em.find(Aluno.class, 1);
	}
	
	public List<Aluno> listaAlunos(){
		TypedQuery<Aluno> q1 = em.createQuery("SELECT * FROM aluno", Aluno.class);
		return (List<Aluno>) q1;
	}
	
}
