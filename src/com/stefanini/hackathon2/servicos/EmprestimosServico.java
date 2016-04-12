package com.stefanini.hackathon2.servicos;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
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
	
