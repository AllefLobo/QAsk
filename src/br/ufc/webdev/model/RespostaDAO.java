package br.ufc.webdev.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class RespostaDAO {

	private static final String RESPOSTA_ID = "id";
	private static final String RESPOSTA_CONTEUDO = "nome";
	private static final String RESPOSTA_ID_CRIADOR = "email";

	
	private Connection connection;
	
	public RespostaDAO(Connection connection){
		this.connection = connection;
	}
	
	private Resposta bindResposta(ResultSet rs) throws SQLException {
		Resposta resposta = new Resposta();
		resposta.setId(rs.getInt(RESPOSTA_ID));
		resposta.setConteudo(rs.getString(RESPOSTA_CONTEUDO));
		resposta.setId_criador(rs.getInt(RESPOSTA_ID_CRIADOR));

		return resposta;
	}
	
	
	 
	public List<Resposta> getAll() throws SQLException{
		List<Resposta> all = new ArrayList<Resposta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;	
		try {
			stmt =	connection.prepareStatement("select * from resposta");
			rs = stmt.executeQuery();
			while(rs.next()){
				Resposta resposta = bindResposta(rs);
				all.add(resposta);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel listar as pessoas");
		} finally {
			closeOpenResources(rs, stmt);
		}
		return all;
	}

	public Resposta findById( int id ) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement("select * from resposta where id_resposta = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.first()){
				Resposta resposta = bindResposta(rs);
				return resposta;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeOpenResources(rs, stmt);
		}
		return null;
	}
	
	public void insert(Resposta resposta) throws SQLException{
		PreparedStatement stmt = null;
		String sql = "insert into resposta(id_resposta, conteudo_resposta, id_criador) values (?,?,?)";
		try {
			stmt = connection.prepareStatement(sql);

			stmt.setInt(1, resposta.getId());
			stmt.setString(2, resposta.getConteudo());
			stmt.setInt(3, resposta.getId_criador());

			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel adicionar a resposta");
		} finally {
				closeOpenResources(stmt);
		}
	}
	
	public void remove(Resposta resposta) {
		PreparedStatement stmt = null;
		String sql = "delete from resposta where id_resposta = ? and id_criador = ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, resposta.getId() );
			stmt.setInt(2, resposta.getId_criador() );
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel remover a resposta");
		} finally {
			closeOpenResources(stmt);
		}
	}
	
	public void update( Resposta resposta ) throws SQLException {

		PreparedStatement stmt = null;
		String sql = "update pessoa set conteudo_resposta = ? where id_resposta = ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, resposta.getConteudo() );
			stmt.setInt(2, resposta.getId() );
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Nao foi possivel alterar a resposta");
		} finally {
				closeOpenResources(stmt);
		}

	}
	
	private void closeOpenResources(PreparedStatement stmt){
		closeOpenResources(null, stmt);
	}
	
	private void closeOpenResources(ResultSet rs, PreparedStatement stmt){
		try { if (rs != null) rs.close(); } catch (Exception e) {};
	    try { if (stmt != null) stmt.close(); } catch (Exception e) {};
	}
}
