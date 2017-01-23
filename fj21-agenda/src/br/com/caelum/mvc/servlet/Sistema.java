package br.com.caelum.mvc.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
			String dataNascimentoTexto = req.getParameter("DATA");
			contato.setNome(nome);
			contato.setEmail(email);
			contato.setEndereco(req.getParameter("endereco"));
			
			Calendar dataNascimento =  null;
			
			try{
				
				Date data = new SimpleDateFormat("dd/MM/yy").parse(dataNascimentoTexto);
				
				dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(data);
			}catch(ParseException e){
				
				throw new RuntimeException();
			}
			
			contato.setDataNascimento(dataNascimento);
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
			
			RequestDispatcher rqp = req.getRequestDispatcher("/contato-adicionado.jsp");
			rqp.forward(req, resp);
			/*
			PrintWriter writer = resp.getWriter();
			
	    	
	    	writer.println("<html>"
	    			+ 	   "<body>"
	    			+ 	   "<h1>Adicionado com sucesso</h1>"
	    			+ 	   "</body>"
	    			+ 	   "</html>");
	    	
	    	writer.println(contato.getNome());
	    	*/
		}

}
