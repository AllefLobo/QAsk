package br.ufc.webdev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufc.webdev.model.Pergunta;
import br.ufc.webdev.model.PerguntaDAO;
import br.ufc.webdev.model.Pessoa;

import com.mysql.jdbc.Connection;
@WebServlet(urlPatterns={"/perguntaController"})
public class perguntaController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(req.getParameter("id_pergunta"));
		
		System.out.println("fasdfhasidfhasiudfh"+id);
		Connection connection = (Connection) req.getAttribute("connection");
		
		PerguntaDAO dao = new PerguntaDAO(connection);
		Pergunta pergunta = dao.buscarPerguntaPorId(id);
		
		req.setAttribute("perguntaResposta", pergunta);
		RequestDispatcher rd = req.getRequestDispatcher("respostasPerguntas.jsp");
		rd.forward(req, resp);
		
	}
}
