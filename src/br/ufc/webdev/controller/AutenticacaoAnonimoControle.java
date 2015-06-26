package br.ufc.webdev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufc.webdev.model.Pessoa;

/**
 * Servlet implementation class AutenticacaoAnonimoControle
 */
@WebServlet("/AutenticacaoAnonimo")
public class AutenticacaoAnonimoControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Pessoa anonima = new Pessoa();
		anonima.setNome("anonimo");
		anonima.setEmail("NULL");
		anonima.setSenha("NULL");
		anonima.setId(0);
		session.setAttribute("anonimo", anonima);
		
		try {
			response.sendRedirect("anonima.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
