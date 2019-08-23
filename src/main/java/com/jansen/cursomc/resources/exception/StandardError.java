package com.jansen.cursomc.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	private String nome;
	private Long timeStamp;

	public StandardError(Integer status, String nome, Long timStamp) {
		super();
		this.status = status;
		this.nome = nome;
		this.timeStamp = timStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getTimStamp() {
		return timeStamp;
	}

	public void setTimStamp(Long timStamp) {
		this.timeStamp = timStamp;
	}

}
