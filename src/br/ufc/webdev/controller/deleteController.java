package br.ufc.webdev.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.webdev.model.Pessoa;
import br.ufc.webdev.model.PessoaDAO;


@WebServlet(name="deletaPessoa", urlPatterns={"/deletaPessoa"})
public class deleteController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (req.getParameter("id") != null) {

			int id = Integer.parseInt(req.getParameter("id"));
			Pessoa pessoa = new Pessoa();
			pessoa.setId(id);
			
			Connection connection = (Connection) req.getAttribute("connection");
			PessoaDAO pDao = new PessoaDAO(connection);

			try {
				pDao.remove(pessoa);
			} catch (RuntimeException ex) {
			}

		} else {
			req.setAttribute("erro", "Pessoa inválido");
		}
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
