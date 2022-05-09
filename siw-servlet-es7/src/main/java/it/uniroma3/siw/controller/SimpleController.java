package it.uniroma3.siw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.siw.model.Persona;

@WebServlet("/persona")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String nextPage;

		// leggo i parametri
		String nome = request.getParameter("nome").toUpperCase();
		String cognome = request.getParameter("cognome").toUpperCase();

		//controllo la validità dei parametri e sceglo la prossima pagina
		if(new Validator().validate(request)) {
			nextPage = "/conferma.jsp";
			//creo una persona e la metto nella request
			Persona p = new Persona(nome, cognome);
			request.setAttribute("persona", p);
		}
		else
			nextPage = "/index.jsp";

		// inoltro

		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 

	}
}