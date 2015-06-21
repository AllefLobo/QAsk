package br.ufc.webdev.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {		
			
		
//		HttpSession session = ((HttpServletRequest) req).getSession(false);
//		
//		String path = ((HttpServletRequest) req).getRequestURI();
//		
//		if( path.contains("login.jsp") || path.contains("autentica") ){
//			chain.doFilter(req, resp);
//		}else if( session != null && session.getAttribute("user") != null ){
			chain.doFilter(req, resp);
//		}else{
//			((HttpServletResponse)resp).sendRedirect("login.jsp");
//			return;
//		}

			
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
