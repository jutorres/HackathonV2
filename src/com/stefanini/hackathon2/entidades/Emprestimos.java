package com.stefanini.hackathon2.entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Emprestimos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmprestimo;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idLivro")
	private Livro livro;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idPessoa")
	private Pessoa pessoa;
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime dataRetirada;
	@Column
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime dataDevolucao;

	public Emprestimos() {
		this.dataRetirada = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm.s");
		this.dataRetirada.format(formatador);
	}

	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}

	public Livro getLivro() {
		return livro;
	}

	public Pessoa getPessoa() {
		return pessoa;
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

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setDataRetirada(LocalDateTime dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public void setDataDevolucao(LocalDateTime dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((dataRetirada == null) ? 0 : dataRetirada.hashCode());
		result = prime * result + ((dataDevolucao == null) ? 0 : dataDevolucao.hashCode());
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
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

}
