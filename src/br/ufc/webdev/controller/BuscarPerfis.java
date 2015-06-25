package br.ufc.webdev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.webdev.model.Pessoa;
import br.ufc.webdev.model.PessoaDAO;

import com.mysql.jdbc.Connection;


@WebServlet(urlPatterns={"/buscarPerfil"})
public class BuscarPerfis extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = req.getParameter("nome");
		
		if(!nome.equals("")){
			Connection connection = (Connection) req.getAttribute("connection");
			PessoaDAO pessoaDao = new PessoaDAO(connection);
			Pessoa pessoa = pessoaDao.buscarPessoa(nome);
			
			if(pessoa != null){
				req.setAttribute("pessoa", pessoa);
				RequestDispatcher rd = req.getRequestDispatcher("pesquisa.jsp");
				rd.forward(req, resp);
			}else{
				req.getRequestDispatcher("pesquisa.jsp").forward(req, resp);
			}			
		}else{
			req.getRequestDispatcher("pesquisa.jsp").forward(req, resp);
		}
		
		
		
		
	}
}
