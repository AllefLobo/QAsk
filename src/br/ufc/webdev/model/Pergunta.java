package br.ufc.webdev.model;

public class Pergunta {
	private int id;
	private String conteudo;
	private int id_remetente;
	private int id_destino;
	private int id_resposta;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public int getId_destino() {
		return id_destino;
	}
	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}
	public int getId_remetente() {
		return id_remetente;
	}
	public void setId_remetente(int id_remetente) {
		this.id_remetente = id_remetente;
	}
	public int getId_resposta() {
		return id_resposta;
	}
	public void setId_resposta(int id_resposta) {
		this.id_resposta = id_resposta;
	}
	
	

}
