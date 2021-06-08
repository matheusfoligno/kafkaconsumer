package br.com.kafkaconsumer.dtos;

import java.io.Serializable;

public class SlackMessage implements Serializable {

	private static final long serialVersionUID = 8500768262598679382L;

	private String data;
	private String mensagem;
	private String erro_status;
	private String stackTrace;
	private String usuario;
	private String sistema;

	public SlackMessage(String data, String mensagem, String erro_status, String stackTrace, String usuario,
			String sistema) {
		super();
		this.data = data;
		this.mensagem = mensagem;
		this.erro_status = erro_status;
		this.stackTrace = stackTrace;
		this.usuario = usuario;
		this.sistema = sistema;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getErro_status() {
		return erro_status;
	}

	public void setErro_status(String erro_status) {
		this.erro_status = erro_status;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
}
