package br.ufc.webdev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

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
import br.ufc.webdev.model.Resposta;
import br.ufc.webdev.model.RespostaDAO;

@WebServlet(urlPatterns={"/listarRespostas"})
public class listarRespostas extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		PerguntaDAO perguntaDAO = new PerguntaDAO(connection);
		RespostaDAO respostaDAO = new RespostaDAO(connection);
		List<Pergunta> listaPerguntas = new ArrayList<Pergunta>();
		
		HttpSession session = ((HttpServletRequest) req).getSession(true);
		
		Pessoa pessoa = (Pessoa) session.getAttribute("user");
		
		listaPerguntas = perguntaDAO.pegarPerguntasDePessoa(pessoa);
		
		List<Pergunta> listPerguntasComResposta = new ArrayList<Pergunta>();
		List<Resposta> listRespostas = respostaDAO.respostaDeUmUsuario(pessoa);
		
		for(Pergunta pergunta : listaPerguntas){
			if(pergunta.getIdResposta() != 0){
				listPerguntasComResposta.add(pergunta);
			}
		}
		
		for(Pergunta p : listPerguntasComResposta){
			for(Resposta r : listRespostas){
				if(p.getIdResposta() == r.getId()){
					p.setResposta(r);
				}
			}
		}
		
		req.setAttribute("respostas", listPerguntasComResposta);
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
		
	}

}
