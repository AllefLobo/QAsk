package br.ufc.webdev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.ufc.webdev.model.Pessoa;
import br.ufc.webdev.model.PessoaDAO;

@WebServlet(name="adicionaPessoa", urlPatterns={"/adicionaPessoa"})
public class InsertController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<String> erros = new ArrayList<String>();
		Pessoa pessoa = new Pessoa();
		if (isValid(req, pessoa, erros)){
			
			Connection connection = (Connection) req.getAttribute("connection");

			PessoaDAO dao = new PessoaDAO(connection);
			try {
				dao.insert(pessoa);
				resp.sendRedirect("index.jsp");
			} catch (SQLException e) {}
			

		} else {
			req.setAttribute("erros", erros);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
	}

	private boolean isValid(HttpServletRequest req, Pessoa pessoa, List<String> erros) {
		
		String nome = req.getParameter("username").trim();
		String email = req.getParameter("email").trim();
		String senha = req.getParameter("password").trim();
		
		
		if (nome == null || senha == null || email == null) {
			erros.add("Preencha os campos de nome e senha");
			
		} else if (nome.trim().equals("") || senha.trim().equals("") || email.trim().equals("")) {
			erros.add("Preencha os campos de nome, senha ou email");
		} else if (erros.isEmpty() == false) {
			return false;
		}
		
		
		pessoa.setNome(nome);
		pessoa.setSenha(senha);
		pessoa.setEmail(email);
		
		return true;
	}

}
