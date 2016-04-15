package com.stefanini.hackathon2.managed.beans;

import java.time.LocalDateTime;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Emprestimos;
import com.stefanini.hackathon2.servicos.EmprestimosServico;
import com.stefanini.hackathon2.util.Mensageiro;

@ManagedBean
@ViewScoped
public class EmprestimosManagedBean {

	private  Emprestimos emprestimo;
	private List<Emprestimos> listaDeEmprestimosCadastrados;
	
	@Inject
	private EmprestimosServico servico;
	
	public EmprestimosManagedBean() {
	}
	
	public void salvar() {
		servico.salvar(getEmprestimo());
		Mensageiro.notificaInformacao("Parabéns!", "Empréstimo salvo com sucesso!");
		carregaListaDeEmprestimos();
		limpar();
	}
	
	public void devolver(Emprestimos emprestimo) {
		servico.devolver(emprestimo);
		Mensageiro.notificaInformacao("Parabéns!", "Livro devolvido com sucesso!");
		carregaListaDeEmprestimos();
		limpar();
	}
	
	public void limpar() {
		setEmprestimo(new Emprestimos());
	}
	
	private void carregaListaDeEmprestimos() {
		setListaDeEmprestimosCadastrados(servico.carregaTodosEmprestimosDoBanco());
	}
	
	public List<Emprestimos> getListaDeEmprestimosCadastrados() {
		if (listaDeEmprestimosCadastrados == null) {
			carregaListaDeEmprestimos();
		}
		return listaDeEmprestimosCadastrados;
	}
	
	public void setListaDeEmprestimosCadastrados(List<Emprestimos> listaDeEmprestimosCadastrados) {
		this.listaDeEmprestimosCadastrados = listaDeEmprestimosCadastrados;
	}
	
	public Emprestimos getEmprestimo() {
		if (emprestimo == null) {
			limpar();
		}
		return emprestimo;
	}
	
	public void setEmprestimo(Emprestimos emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	public String getDiasEmAtraso(String dataRetiradaString, String dataEntregaString) {
		LocalDateTime localDateTimeRetirada;
		LocalDateTime localDateTimeEntrega = null;
		if(dataEntregaString.length() == 16) {
			localDateTimeEntrega = LocalDateTime.parse(dataEntregaString);
		}		
		try {
			localDateTimeRetirada = LocalDateTime.parse(dataRetiradaString);
			return String.valueOf(servico.calcIntervaloDias(localDateTimeRetirada, localDateTimeEntrega));
		} catch (Exception e) {
			return "0";
		}
	}
}
