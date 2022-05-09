package it.uniroma3.siw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Validator {
	
	boolean validate(HttpServletRequest request) {
		Boolean valid = true;
		Map<String, String> messaggiErrori = new HashMap<>();
		
		//prendo i valori
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		
		//controllo i valori se sono validi
		if(nome.isBlank()) {
			messaggiErrori.put("nome", "nome non valido");
			valid = false;
		}
		if(cognome.isBlank()) {
			messaggiErrori.put("cognome", "cognome non valido");
			valid = false;
		}
		
		request.setAttribute("messaggiErrore", messaggiErrori);
		return valid;
		
		
	}
}
