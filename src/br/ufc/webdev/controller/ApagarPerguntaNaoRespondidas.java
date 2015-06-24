package br.ufc.webdev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.webdev.model.PerguntaDAO;
import br.ufc.webdev.model.RespostaDAO;

import com.mysql.jdbc.Connection;

@WebServlet(urlPatterns={"/apagarPerguntaNaoRespondidas"})
public class ApagarPerguntaNaoRespondidas extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id_pergunta = Integer.parseInt(req.getParameter("id_pergunta"));
		
		Connection connection = (Connection) req.getAttribute("connection");
		PerguntaDAO pDao = new PerguntaDAO(connection);
		
		pDao.removerPergunta(id_pergunta);
		
		RequestDispatcher rd = req.getRequestDispatcher("listaPergunta");
		rd.forward(req, resp);
	}
}
