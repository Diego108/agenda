package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet(name="sistema", urlPatterns="/sistema")
public class Sistema extends HttpServlet{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			
			Contato contato = new Contato();
			
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			contato.setNome(nome);
			contato.setEmail(email);
			
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
			
			PrintWriter writer = resp.getWriter();
	    	
	    	writer.println("<html>"
	    			+ 	   "<body>"
	    			+ 	   "<h1>Adicionado com sucesso</h1>"
	    			+ 	   "</body>"
	    			+ 	   "</html>");
		}

}
