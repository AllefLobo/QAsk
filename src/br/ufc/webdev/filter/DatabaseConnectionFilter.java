package br.ufc.webdev.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.ufc.webdev.model.ConnectionFactory;

@WebFilter("/*")
public class DatabaseConnectionFilter implements Filter {

	@Override
	public void destroy() {

	}
 
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		Connection connection = new ConnectionFactory().getConnection();
		req.setAttribute("connection", connection);
		chain.doFilter(req, resp);
		try {connection.close();} catch (SQLException e) {}
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
