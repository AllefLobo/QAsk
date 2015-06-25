package br.ufc.webdev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import br.ufc.webdev.model.Pergunta;
import br.ufc.webdev.model.PerguntaDAO;
import br.ufc.webdev.model.Pessoa;
import br.ufc.webdev.model.PessoaDAO;
import br.ufc.webdev.model.Resposta;
import br.ufc.webdev.model.RespostaDAO;

@WebServlet(urlPatterns={"/perfilController"})
public class PerfilController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		Connection connection = (Connection) req.getAttribute("connection");
		
		HttpSession session = req.getSession(true);
		RespostaDAO respostaDAO = new RespostaDAO(connection);
		PessoaDAO pessoaDAO = new PessoaDAO(connection);
		
		String perfil = req.getParameter("perfil");
		
		Pessoa pessoa = pessoaDAO.buscarPessoa(perfil);
		
		List<Resposta> respostas = respostaDAO.respostaDeUmUsuario(pessoa);
		
		session.setAttribute("perfil", pessoa);
		session.setAttribute("respostas", respostas);
		req.getRequestDispatcher("listarRespostasPerfil").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String conteudo = req.getParameter("pergunta");
		System.out.println(conteudo);
		
		HttpSession session = req.getSession(true);
		
		Connection connection = (Connection) req.getAttribute("connection");
		PerguntaDAO dao = new PerguntaDAO(connection);
		
		Pessoa remetente = (Pessoa) session.getAttribute("user");
		Pessoa destinatario = (Pessoa) session.getAttribute("perfil");
		
		Pergunta pergunta = new Pergunta();
		pergunta.setConteudo(conteudo);
		pergunta.setIdRemetente(remetente.getId());
		pergunta.setIdDestinatario(destinatario.getId());
		
		
			dao.addPergunta(pergunta);
		
		req.getRequestDispatcher("listarRespostasPerfil").forward(req, resp);
	}
}
