package br.com.caelum.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("*")
public class FIltro implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Entrei no Filtro...");
		Long tempoInicial = System.currentTimeMillis();
		String uri = ((HttpServletRequest)request).getRequestURI();
		String parametros = ((HttpServletRequest)request).getParameter("logica");
		chain.doFilter(request, response);
		Long tempoFinal = System.currentTimeMillis();
		System.out.println("Sai do Filtro...tempo final da requisição no filtro :" + (tempoFinal - tempoInicial));
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
