package br.ufc.webdev.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class PessoaDAO {

	private static final String PESSOA_ID = "id";
	private static final String PESSOA_NOME = "nome";
	private static final String PESSOA_EMAIL = "email";
	private static final String PESSOA_SENHA = "senha";
	
	private Connection connection;
	
	public PessoaDAO(Connection connection){
		this.connection = connection;
	}
	
	private Pessoa bindProduto(ResultSet rs) throws SQLException {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(rs.getInt(PESSOA_ID));
		pessoa.setNome(rs.getString(PESSOA_NOME));
		pessoa.setEmail(rs.getString(PESSOA_EMAIL));
		pessoa.setSenha(rs.getString(PESSOA_SENHA));
		return pessoa;
	}
	
	
	 
	public List<Pessoa> getAll() throws SQLException{
		List<Pessoa> all = new ArrayList<Pessoa>();
		PreparedStatement stmt = null;
		ResultSet rs = null;	
		try {
			stmt =	connection.prepareStatement("Select * from pessoas");
			rs = stmt.executeQuery();
			while(rs.next()){
				Pessoa pessoa = bindProduto(rs);
				all.add(pessoa);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel listar as pessoas");
		} finally {
			closeOpenResources(rs, stmt);
		}
		return all;
	}

	public Pessoa findById(Long id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement("Select * from pessoa where id = ?");
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			if(rs.first()){
				Pessoa pessoa = bindProduto(rs);
				return pessoa;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeOpenResources(rs, stmt);
		}
		return null;
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
