package br.ufc.webdev.model;

public class Pergunta {
	private int id;
	private int idRemetente;
	private int idDestinatario;
	private int idResposta;
	public int getIdResposta() {
		return idResposta;
	}
	public void setIdResposta(int idResposta) {
		this.idResposta = idResposta;
	}
	public int getIdRemetente() {
		return idRemetente;
	}
	public void setIdRemetente(int idRemetente) {
		this.idRemetente = idRemetente;
	}
	public int getIdDestinatario() {
		return idDestinatario;
	}
	public void setIdDestinatario(int idDestinatario) {
		this.idDestinatario = idDestinatario;
	}
	private String conteudo;
	
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
	
	

}
