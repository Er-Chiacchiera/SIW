package it.uniroma3.siw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
		// gestione della RICHIESTA
		Map<String, String> messaggiErrore =new HashMap<>();
		
		
		// leggo i parametri
	  	String nome = request.getParameter("nome").toUpperCase();
	  	String cognome = request.getParameter("cognome").toUpperCase();

		request.setAttribute("nome", nome);
		request.setAttribute("cognome", cognome);
		
		messaggiErrore.put(nome, "nome non valido");
		messaggiErrore.put(cognome, "cognome non valido");
		if(nome==null)
			request.setAttribute("Errore", messaggiErrore.get(nome));
		
		if(cognome==null)
			request.setAttribute("Errore", messaggiErrore.get(cognome));
		
		
		

		// inoltro

		ServletContext application  = getServletContext();
		
		RequestDispatcher rd = application.getRequestDispatcher("/persona.jsp");
		rd.forward(request, response);
		return; 
	 	
	}
}