package com.stefanini.hackathon2.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
@Entity
public class Login {
      
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLogin;

	@Column(nullable = false)
	private String usuario;

	@Column(nullable = false)
	private String senha;

	@Column
	@Temporal(TemporalType.DATE)
	private Date ultimoAcesso;

	@Column(nullable = true)
	private Boolean logado;

	public Login() {

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public Integer getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(Integer idLogin) {
		this.idLogin = idLogin;
	}

	public Boolean getLogado() {
		return logado;
	}

	public void setLogado(Boolean logado) {
		this.logado = logado;
	}

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLogin == null) ? 0 : idLogin.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((ultimoAcesso == null) ? 0 : ultimoAcesso.hashCode());
		result = prime * result + ((logado == null) ? 0 : logado.hashCode());
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
		Login other = (Login) obj;
		if (idLogin == null) {
			if (other.idLogin != null)
				return false;
		} else if (!idLogin.equals(other.idLogin))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (ultimoAcesso == null) {
			if (other.ultimoAcesso != null)
				return false;
		} else if (!ultimoAcesso.equals(other.ultimoAcesso))
			return false;
		if (logado == null) {
			if (other.logado != null)
				return false;
		} else if (!logado.equals(other.logado))
			return false;
		return true;
	}

 }
