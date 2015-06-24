package br.ufc.webdev.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import br.ufc.webdev.model.PerguntaDAO;
import br.ufc.webdev.model.Pessoa;
import br.ufc.webdev.model.Resposta;
import br.ufc.webdev.model.RespostaDAO;

import com.mysql.jdbc.Connection;
@WebServlet(urlPatterns={"/respostaController"})
public class respostaController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String texto =req.getParameter("resposta");
		int id_pergunta = Integer.parseInt(req.getParameter("id_pergunta"));
		
		
		Connection connection = (Connection) req.getAttribute("connection");
		RespostaDAO rDao = new RespostaDAO(connection);
		PerguntaDAO pDao = new PerguntaDAO(connection);
		Resposta r = new Resposta();
		HttpSession session = ((HttpServletRequest) req).getSession(true);
		Pessoa pessoa = (Pessoa) session.getAttribute("user");
		
		r.setConteudo(texto);
		r.setId_criador(pessoa.getId());
		
		if(texto != null){
			try {
				rDao.insert(r);
				r = rDao.buscaResposta(pessoa.getId(), texto);
				System.out.println("asfasdfasdf");
				pDao.addResposta(id_pergunta, r.getId());
				RequestDispatcher rd = req.getRequestDispatcher("listarRespostas");
				rd.forward(req, resp);	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(null, "se fudeo");
		}
		
		
	}
}
