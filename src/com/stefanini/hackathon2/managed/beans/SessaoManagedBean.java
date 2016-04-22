package com.stefanini.hackathon2.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Login;
import com.stefanini.hackathon2.servicos.LoginServico;

@ManagedBean(eager = true)
@SessionScoped
public class SessaoManagedBean {

	private String usuario;
	private String senha;

	@Inject
	private LoginServico servico;
	
	@Inject
	private Login login;

	public SessaoManagedBean() {

	}

	public String enviar() {

		List<Login> listaLoginsDoBanco = servico.carregaTodosLoginsDoBanco();
		for (Login loginDoBanco : listaLoginsDoBanco) {
			if (loginDoBanco.getUsuario().equals(usuario) && loginDoBanco.getSenha().equals(senha)) {
				this.login = loginDoBanco;
				login.setLogado(true);
				return "principal.xhtml?faces-redirect=true";
			}
		}
		return "error.xhtml?faces-redirect=true";

	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public LoginServico getServico() {
		return servico;
	}

	public Login getLogin() {
		return login;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setServico(LoginServico servico) {
		this.servico = servico;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	public String sair() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.getExternalContext().invalidateSession();
		return "principal.xhtml?faces-redirect=true";
	}

}
