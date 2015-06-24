package br.ufc.webdev.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufc.webdev.model.PessoaDAO;

/**
 * Servlet implementation class FazerAmizadeController
 */
@WebServlet("/FazerAmizadeController")
public class FazerAmizadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		
		Connection con = (Connection) request.getAttribute("connection");
		PessoaDAO pDao = new PessoaDAO(con);
		HttpSession sessao = request.getSession(false);
		
		int id_amigo = Integer.parseInt(request.getParameter("id_amigo"));
		
		int id_pessoa = (int) sessao.getAttribute("id_pessoa");
		
		if(id_amigo > 0 && id_amigo != id_pessoa){
			pDao.fazAmizade(id_pessoa, id_amigo);
		}
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
