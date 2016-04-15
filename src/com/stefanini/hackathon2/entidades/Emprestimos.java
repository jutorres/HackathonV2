package com.stefanini.hackathon2.entidades;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Emprestimos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmprestimo;
	
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idLivro")
	private List<Livro> livros;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idPessoa")
	private Pessoa pessoa;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idFuncionario")
	private Funcionario funcionario;
	
	@Column
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime dataRetirada;
	
	@Column
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime dataDevolucao;
	
	@Column
	private String status;

	public Emprestimos() {
		this.dataRetirada = LocalDateTime.now();
	}

	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public LocalDateTime getDataRetirada() {
		return dataRetirada;
	}

	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}

	public void setIdEmprestimo(Integer idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setDataRetirada(LocalDateTime dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public void setDataDevolucao(LocalDateTime dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((livros == null) ? 0 : livros.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((dataRetirada == null) ? 0 : dataRetirada.hashCode());
		result = prime * result + ((dataDevolucao == null) ? 0 : dataDevolucao.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimos other = (Emprestimos) obj;
		if (dataDevolucao == null) {
			if (other.dataDevolucao != null)
				return false;
		} else if (!dataDevolucao.equals(other.dataDevolucao))
			return false;
		if (dataRetirada == null) {
			if (other.dataRetirada != null)
				return false;
		} else if (!dataRetirada.equals(other.dataRetirada))
			return false;
		if (idEmprestimo == null) {
			if (other.idEmprestimo != null)
				return false;
		} else if (!idEmprestimo.equals(other.idEmprestimo))
			return false;
		if (livros == null) {
			if (other.livros != null)
				return false;
		} else if (!livros.equals(other.livros))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}
