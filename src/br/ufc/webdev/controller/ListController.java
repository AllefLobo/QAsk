package br.ufc.webdev.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.webdev.model.Pessoa;
import br.ufc.webdev.model.PessoaDAO;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/ListarPessoa")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		// TODO Auto-generated method stub
		
		
		Connection connection = (Connection) req.getAttribute("connection");
		PessoaDAO dao = new PessoaDAO(connection);
		try {
			List<Pessoa> pessoas = dao.getAll();
			req.setAttribute("pessoa", pessoas);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			
		} catch (SQLException | ServletException | IOException e) {}
	
	}
		
}


