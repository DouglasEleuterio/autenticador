package br.com.autenticador.dto;

public class RespostaAutenticarDto {
	
	private Integer erro;
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Integer getErro() {
		return erro;
	}
	public void setErro(Integer erro) {
		this.erro = erro;
	}
}