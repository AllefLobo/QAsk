package br.ufc.webdev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import br.ufc.webdev.model.Pessoa;
import br.ufc.webdev.model.PessoaDAO;

/**
 * Servlet implementation class AutenticacaoAnonimoControle
 */
@WebServlet("/AutenticacaoAnonimo")
public class AutenticacaoAnonimoControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Connection connection = (Connection) request.getAttribute("connection");
		HttpSession session = request.getSession();
		PessoaDAO dao = new PessoaDAO(connection);
		Pessoa anonima = new Pessoa();
		
		anonima = dao.buscarPessoa(1);
		session.setAttribute("anonimo", anonima);
		
		try {
			response.sendRedirect("anonima.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
