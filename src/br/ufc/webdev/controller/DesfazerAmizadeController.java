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

import br.ufc.webdev.model.Pessoa;
import br.ufc.webdev.model.PessoaDAO;


@WebServlet(urlPatterns={"/desfazerAmizade"})
public class DesfazerAmizadeController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = (Connection) request.getAttribute("connection");
		PessoaDAO pDao = new PessoaDAO(con);
		HttpSession sessao = request.getSession(false);
		
		int id_amigo = Integer.parseInt(request.getParameter("id_amigo"));
		
		Pessoa pessoa = (Pessoa) sessao.getAttribute("user");
		
		int id_pessoa = pessoa.getId();
		
		if(id_amigo > 0 && id_amigo != id_pessoa){
			
			pDao.desfazerAmizade(id_pessoa, id_amigo);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("pegarAmigos");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
