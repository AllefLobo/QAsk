package br.ufc.webdev.controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.webdev.model.Pessoa;
import br.ufc.webdev.model.PessoaDAO;


@WebServlet("/editarProduto")
public class EditController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//"editar.jsp"
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		Connection connection = (Connection) req.getAttribute("connection");
		
		
		req.getRequestDispatcher("editar.jsp").forward(req, resp);
				
		
	}

}
