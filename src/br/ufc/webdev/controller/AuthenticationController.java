package br.ufc.webdev.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import br.ufc.webdev.model.Pessoa;
import br.ufc.webdev.model.PessoaDAO;

@WebServlet("/autentica")
public class AuthenticationController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// sucesso - index.jsp
		
		// erro - login.jsp
		Connection connection = (Connection) req.getAttribute("connection");
		PessoaDAO dao = new PessoaDAO(connection);
		
		String nome = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome(nome);
		pessoa.setSenha(senha);
		
//		if( dao.authenticate(usuario) ){
//			List<Produto> lista = new ArrayList();
//			System.out.println(dao.authenticate(usuario));
//			HttpSession session = req.getSession();
//			session.setAttribute("user", usuario);
//			session.setAttribute("lista", lista);
//			
//			resp.sendRedirect("index.jsp");
//			return;			
//		}else{
//			resp.sendRedirect("login.jsp");
//			return;
//		}
	}

}
