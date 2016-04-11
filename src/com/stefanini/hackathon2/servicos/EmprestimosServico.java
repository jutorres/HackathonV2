package com.stefanini.hackathon2.servicos;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Emprestimos;
import com.stefanini.hackathon2.repositorios.EmprestimosRepositorio;
import com.stefanini.hackathon2.transacao.Transacional;

public class EmprestimosServico {

	@Inject
	private EmprestimosRepositorio repositorio;
	
	@Transacional
	public void salvar(Emprestimos emprestimo) {
		if (emprestimo.getIdEmprestimo() == null) {
			repositorio.inserir(emprestimo);
			//....
		} else {
			repositorio.atualizar(emprestimo);
		}
	}

	@Transacional
	public List<Emprestimos> carregaTodosEmprestimosDoBanco() {
		return repositorio.todosEmprestimos();
	}

	@Transacional
	public void deletar(Emprestimos emprestimo) {
		repositorio.remover(emprestimo);
	}
}
	
