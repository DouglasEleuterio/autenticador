package br.com.autenticador.dto;

import javax.validation.constraints.NotNull;

public class AutenticarDto {
	
	@NotNull
	private String login;
	@NotNull
	private String senha;
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
}