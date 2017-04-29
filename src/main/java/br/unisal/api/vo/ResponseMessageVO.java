package br.unisal.api.vo;

import java.io.Serializable;

import br.unisal.api.util.GsonSingleton;

public class ResponseMessageVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6647185671286372367L;
	int codigo;
	String mensagem;

	public ResponseMessageVO(int codigo, String mensagem) {
		super();
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return GsonSingleton.getInstance().toJson(this);
	}

}
