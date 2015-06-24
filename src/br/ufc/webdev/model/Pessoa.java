package br.ufc.webdev.model;

import java.util.List;

public class Pessoa {
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String sobre;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSobre() {
		return sobre;
	}
	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	

}
