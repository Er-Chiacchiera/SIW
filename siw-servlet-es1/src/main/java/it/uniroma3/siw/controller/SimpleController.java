package it.uniroma3.siw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/persona")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		String nextPage;
		
		// leggo i parametri
	  	String nome = request.getParameter("nome").toUpperCase();
	  	String cognome = request.getParameter("cognome").toUpperCase();
	  	//set parametri
		request.setAttribute("nome", nome);
		request.setAttribute("cognome", cognome);
		
		
		//controllo la validità dei parametri e sceglo la prossima pagina
		if(new Validator().validate(request))
			nextPage = "/persona.jsp";
		else
			nextPage = "/index.jsp";
		
		
		

		// inoltro

		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 
	 	
	}
}