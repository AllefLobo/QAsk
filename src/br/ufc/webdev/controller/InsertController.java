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

@WebServlet(urlPatterns={"/adicionaPessoa"})
public class InsertController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Pessoa pessoa = new Pessoa();
		
		if (isValid(req, pessoa)){
			
			Connection connection = (Connection) req.getAttribute("connection");

			PessoaDAO dao = new PessoaDAO(connection);
			try {
				if( !dao.authenticate(pessoa) ){
					dao.insert(pessoa);
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
				
				req.setAttribute("erro", "uma pessoa com nome "+pessoa.getNome()+" já existe!");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			} catch (SQLException e) {
				
			}
			

		} else {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
	}

	private boolean isValid(HttpServletRequest req, Pessoa pessoa) {
		 
		String nome = req.getParameter("register-username").trim();
		String email = req.getParameter("register-email").trim();
		String senha = req.getParameter("register-password").trim();
		String confirmaSenha = req.getParameter("register-confirm-password").trim();
		
		
		if (nome == null || senha == null || email == null ) {
			return false;
			
		} else if (nome.trim().equals("") || senha.trim().equals("") || email.trim().equals("")) {
			return false;
		}else if( !senha.equals(confirmaSenha) ){
			return false;
		}
		
		
		
		pessoa.setNome(nome);
		pessoa.setSenha(senha);
		pessoa.setEmail(email);
		
		System.out.println("nome"+pessoa.getNome());
		
		return true;
	}

}
