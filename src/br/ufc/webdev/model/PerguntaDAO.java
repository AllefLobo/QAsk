package br.ufc.webdev.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

public class PerguntaDAO {
	private static final String PERGUNTA_ID = "id";
	private static final String PERGUNTA_IDREMETENTE = "idRemetente";
	private static final String PERGUNTA_IDDESTINATARIO = "idDestinatario";
	private static final String PERGUNTA_CONTEUDO = "conteudo";
	
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
			smt = connection.prepareStatement("Select *from pergunta as pt, pessoa ps where pt.id_destino = ?");
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
}
