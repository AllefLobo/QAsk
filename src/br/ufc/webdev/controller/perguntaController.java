package br.ufc.webdev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.webdev.model.PerguntaDAO;

import com.mysql.jdbc.Connection;
@WebServlet(urlPatterns={"/pergunta"})
public class perguntaController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connection = (Connection) req.getAttribute("connection");
		
		PerguntaDAO dao = new PerguntaDAO(connection);
		
		
		
	}
}
