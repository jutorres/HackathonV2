package com.stefanini.hackathon2.entidades;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idLivro;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String autor;
	
	@Column(nullable=false)
	private Integer paginas;
	
	@Lob
	@Column(nullable = true)
	private byte[] photo;
	
	@Column(nullable = false)
	private Integer estoque;
	
	public Livro() {
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public String getNome() {
		return nome;
	}

	public String getAutor() {
		return autor;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((estoque == null) ? 0 : estoque.hashCode());
		result = prime * result + ((idLivro == null) ? 0 : idLivro.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((paginas == null) ? 0 : paginas.hashCode());
		result = prime * result + Arrays.hashCode(photo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (estoque == null) {
			if (other.estoque != null)
				return false;
		} else if (!estoque.equals(other.estoque))
			return false;
		if (idLivro == null) {
			if (other.idLivro != null)
				return false;
		} else if (!idLivro.equals(other.idLivro))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (paginas == null) {
			if (other.paginas != null)
				return false;
		} else if (!paginas.equals(other.paginas))
			return false;
		if (!Arrays.equals(photo, other.photo))
			return false;
		return true;
	}
}
