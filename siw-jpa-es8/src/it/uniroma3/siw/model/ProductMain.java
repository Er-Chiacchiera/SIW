package it.uniroma3.siw.model;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ProductMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();

		float prezzo;
		
		
		Scanner lettura = new Scanner(System.in);

		/*Prodotti per push*/
		Product p1 = new Product("cocacola", 5, "01");
		Product p2 = new Product("fanta", 7, "02");
		Product p3 = new Product("cocacola", 5, "03");
		Product p4 = new Product("fanta", 7, "04");
		Product p5 = new Product("sprite", 10, "05");


		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);
		tx.commit();
		
		System.out.println("Set price coglione\n");
		prezzo = lettura.nextFloat();
		
		TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.price<:prezzoDaSettare",Product.class);
		query.setParameter("prezzoDaSettare",prezzo);
		List<Product> prodotti = query.getResultList();
		
		for(Product p : prodotti)
			System.out.print(p.getCode()+" ");
		System.out.println("\n\n");
		
		lettura.close();
		
		em.close();
		emf.close();
	}
}
