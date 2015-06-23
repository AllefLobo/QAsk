package br.ufc.webdev.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

public class PerguntaDAO {
	private static final String PERGUNTA_ID = "id_pergunta";
	private static final String PERGUNTA_IDREMETENTE = "id_remetente";
	private static final String PERGUNTA_IDDESTINATARIO = "id_destino";
	private static final String PERGUNTA_CONTEUDO = "conteudo_pergunta";
	
	private Connection connection;
	
	public PerguntaDAO(Connection connection){
		this.connection = connection;
	}
	
	private Pergunta bindPergunta(ResultSet rs) throws SQLException {
		Pergunta pergunta = new Pergunta();
		pergunta.setId(rs.getInt(PERGUNTA_ID));
		pergunta.setIdRemetente(rs.getInt(PERGUNTA_IDREMETENTE));
		pergunta.setIdDestinatario(rs.getInt(PERGUNTA_IDDESTINATARIO));
		pergunta.setConteudo(rs.getString(PERGUNTA_CONTEUDO));
		return pergunta;
	}
	
	public List<Pergunta> pegarPerguntasDePessoa(Pessoa pessoa){ 
		List<Pergunta> all = new ArrayList<Pergunta>();
		PreparedStatement smt;
		ResultSet rs = null;
		
		try {
			smt = connection.prepareStatement("Select * from pergunta pt where pt.id_destino = ?");
			smt.setInt(1, pessoa.getId());
			rs = smt.executeQuery();
			while(rs.next()){
				Pergunta pergunta = bindPergunta(rs);
				all.add(pergunta);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return all;
	}
	
	public void addPergunta(Pergunta pergunta){
		PreparedStatement smt;
		String sql = "insert into pergunta(id_remetente,id_destino,conteudo_pergunta) values(?,?,?)";
		try {
			smt = connection.prepareStatement(sql);
			smt.setInt(1, pergunta.getIdRemetente());
			smt.setInt(2, pergunta.getIdDestinatario());
			smt.setString(3, pergunta.getConteudo());
			smt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ou passo o objetoPergunta
	public void removerPergunta(int idPergunta){
		PreparedStatement smt;
		String sql = "DELETE FROM pergunta WHERE id_pergunta=?";
		try {
			smt = connection.prepareStatement(sql);
			smt.setInt(1, idPergunta);
			smt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Pergunta buscarPerguntaPorId(int id){
		PreparedStatement smt = null;
		ResultSet rs = null;
		String sql = "select * from pergunta where id_pergunta = ?";
		try {
			smt = connection.prepareStatement("select * from pergunta where id_pergunta = ?");
			smt.setInt(1, id);
			rs = smt.executeQuery();
			
			if(rs.first()){
				Pergunta pergunta = bindPergunta(rs);
				return pergunta;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
