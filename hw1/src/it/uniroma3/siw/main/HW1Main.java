package it.uniroma3.siw.main;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.model.Azienda;
import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Docente;
import it.uniroma3.siw.model.Luogo;

public class HW1Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hw1-unit");
		EntityManager em = emf.createEntityManager();
		Allievo allievo1 = new Allievo("Valerio", "Ribaldi", 01);
		Azienda azienda1 = new Azienda("conad");
		allievo1.setAzienda(azienda1);
		Docente docente1 = new Docente("Pip", "Po", "piva01");
		Corso corso1 = new Corso("Matematica", null, 3, docente1);
		Luogo luogo1 = new Luogo("via", 000, "Roma", "11111", "RM");
		azienda1.setLuogo(luogo1);
		

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(allievo1);
		em.persist(azienda1);
		em.persist(docente1);
		em.persist(corso1);
		em.persist(luogo1);
		tx.commit();

		em.close();
		emf.close();
	}
}