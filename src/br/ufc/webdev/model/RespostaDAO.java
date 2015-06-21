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
			stmt =	connection.prepareStatement("Select * from resposta");
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

	public boolean authenticate( Pessoa pessoa ) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement("Select * from pessoa where nome = ? and senha = ?");
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getSenha());
			rs = stmt.executeQuery();
			return rs.first();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeOpenResources(rs, stmt);
		}
		return false;
	}
	
	public void insert(Pessoa pessoa) throws SQLException{
		PreparedStatement stmt = null;
		String sql = "insert into pessoa(nome, email, senha) values (?,?,?)";
		try {
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getSenha());

			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel adicionar a pessoa");
		} finally {
				closeOpenResources(stmt);
		}
	}
	
	public void remove(Pessoa produto) {
		PreparedStatement stmt = null;
		String sql = "delete from pessoa where id = ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, produto.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel remover a pessoa");
		} finally {
			closeOpenResources(stmt);
		}
	}
	
	public void update(Pessoa pessoa) throws SQLException {

		PreparedStatement stmt = null;
		String sql = "update pessoa set nome = ?, email = ?, senha = ? where id = ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getSenha());
			stmt.setLong(4, pessoa.getId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Nao foi possivel alterar pessoa");
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
