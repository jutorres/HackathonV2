package com.stefanini.hackathon2.servicos;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Emprestimos;
import com.stefanini.hackathon2.entidades.Livro;
import com.stefanini.hackathon2.repositorios.EmprestimosRepositorio;
import com.stefanini.hackathon2.transacao.Transacional;

public class EmprestimosServico {

	@Inject
	private EmprestimosRepositorio repositorio;
	
	@Transacional
	public void salvar(Emprestimos emprestimo) {
		if (emprestimo.getIdEmprestimo() == null) {
			if (emprestimo.getStatus() == null) {
				for (Livro livroVerificaEstoque : emprestimo.getLivros()) {
					if (livroVerificaEstoque.getEstoque() <= 1) {
						System.out.println("não rolou");
					} else {
						for (Livro livroDiminuirEstoque : emprestimo.getLivros()) {
							livroDiminuirEstoque.setEstoque(livroDiminuirEstoque.getEstoque() - 1);
						}
						emprestimo.setStatus("Alugado");
						emprestimo.setDataRetirada(LocalDateTime.now());
						repositorio.inserir(emprestimo);
					}
				}
			}
		}
	}

	@Transacional
	public List<Emprestimos> carregaTodosEmprestimosDoBanco() {
		return repositorio.todosEmprestimos();
	}

	@Transacional
	public void devolver(Emprestimos emprestimo) {
		if (emprestimo.getStatus() != null) {
			emprestimo.setStatus(null);
			emprestimo.setDataDevolucao(LocalDateTime.now());
			for (Livro livroAtribuirEstoque : emprestimo.getLivros()) {
				livroAtribuirEstoque.setEstoque(livroAtribuirEstoque.getEstoque() + 1);
			}
			repositorio.devolver(emprestimo);
		}
	}
	
	@Transacional
	public int calcIntervaloDias(LocalDateTime begin, LocalDateTime end) {
		LocalDateTime weekDay = begin;
		Integer dayQuantity = 0;

		if(end == null) {
			end = LocalDateTime.now();
		}
		
		while(weekDay.isBefore(end)) {
			if(weekDay.getDayOfWeek() == DayOfWeek.FRIDAY) {
				weekDay = weekDay.plusDays(3);
			} else {
				weekDay = weekDay.plusDays(1);
			}
			dayQuantity++;
		}
		return dayQuantity <= 7 ? 0 : dayQuantity - 7;
	}
}
	
