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

/**
 * Servlet implementation class FriendControlles
 */
@WebServlet("/pegarAmigos")
public class FriendControlles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		
		Connection con = (Connection) request.getAttribute("connection");
		PessoaDAO pdao = new PessoaDAO(con);
		List<Pessoa> amigos = new ArrayList<Pessoa>();
		
		HttpSession sessao = request.getSession();
		
		int id = (int) sessao.getAttribute("id_pessoa");
		
		amigos = pdao.bindAmigosPessoa(id);
		
		request.setAttribute("listaAmigos", amigos);
		try {
			request.getRequestDispatcher("amigos.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
