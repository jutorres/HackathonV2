package com.stefanini.hackathon2.repositorios;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.hackathon2.entidades.Emprestimos;
import com.stefanini.hackathon2.entidades.Livro;

@SuppressWarnings("all")
public class EmprestimosRepositorio {

	@Inject
	private EntityManager entityManager;
	
	public void inserir(Emprestimos emprestimo) {
		entityManager.persist(emprestimo);
	}

	public List<Emprestimos> todosEmprestimos() {
		return entityManager.createQuery("select l from " + Emprestimos.class.getSimpleName() + " l").getResultList();
	}

	public void atualizar(Emprestimos emprestimo) {
		entityManager.merge(emprestimo);	
	}
	
	public void devolver(Emprestimos emprestimo) {
		  entityManager.merge(emprestimo);
		 }
	
	public Emprestimos pesquisarPorID(Integer id) {
		return entityManager.find(Emprestimos.class, id);
	}
}
