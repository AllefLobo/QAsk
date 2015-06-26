package br.ufc.webdev.controller.anonimo;

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

/**
 * Servlet implementation class BuscarPerfilAnonimo
 */
@WebServlet("/BuscarPerfilAnonimo")
public class BuscarPerfilAnonimo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp)  {
		// TODO Auto-generated method stub
		
		String nome = req.getParameter("nome");
		
		if(!nome.equals("")){
			Connection connection = (Connection) req.getAttribute("connection");
			PessoaDAO pessoaDao = new PessoaDAO(connection);
			Pessoa pessoa = pessoaDao.buscarPessoa(nome);
			
			
	
			if(pessoa != null){
				req.setAttribute("pessoa", pessoa);
				RequestDispatcher rd = req.getRequestDispatcher("anonima.jsp");
				try {
					rd.forward(req, resp);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					req.getRequestDispatcher("anomima.jsp").forward(req, resp);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}else{
			try {
				req.getRequestDispatcher("aninoma.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
	

}
