package it.uniroma3.siw.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	Query deleteQuery = em.createQuery("DELETE FROM Product p");
	static Product P1;
	static Product P2;

	@BeforeAll
	public static void initEntityManager() throws Exception {

		emf = Persistence.createEntityManagerFactory("products-unit-test");
		em = emf.createEntityManager();


	}


	@AfterAll
	public static void closeEntityManager() throws SQLException {
		if (em != null) em.close();
		if (emf != null) emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		tx = em.getTransaction();
		Query deleteQuery = em.createQuery("DELETE FROM Product p");
		P1 = new Product();
		P1.setName("AAAA");
		P1.setCode("01");
		P2 = new Product();
		P2.setName("BBBB");
		P2.setCode("02");
		tx.begin();
		deleteQuery.executeUpdate();
		em.persist(P1);
		em.persist(P2);
		tx.commit();
	}

	@Test
	void dynamicQueryTest() {
		TypedQuery<Product> selectQuery = em.createQuery("SELECT p FROM Product p", Product.class);
		List<Product> prodotti = selectQuery.getResultList();

		assertEquals(prodotti.isEmpty(), false);
		assertEquals(prodotti.contains(P1), true);
		assertEquals(prodotti.get(0).getCode(), "01");

		Query deleteQuery=em.createQuery("DELETE FROM Product p ");
		tx.begin();
		assertEquals(2, deleteQuery.executeUpdate());
		tx.commit();

	}


	@Test
	void namedQueryTest(){
		TypedQuery<Product> selectQuery=em.createNamedQuery("selectAllProduct", Product.class);
		List<Product> prodotti=selectQuery.getResultList();
		assertFalse(prodotti.isEmpty());
		assertTrue(prodotti.contains(P1));
		assertEquals(prodotti.get(0).getCode(), "01");
		Query deleteQuery=em.createNamedQuery("deleteAllProduct");
		tx.begin();
		assertEquals(2,deleteQuery.executeUpdate());
		tx.commit();

	}

	@Test
	void nativeQueryTest() {
		Query selectQuery= em.createNativeQuery("SELECT * FROM Product",Product.class);
		@SuppressWarnings("unchecked")
		List<Product> prodotti = selectQuery.getResultList();
		assertEquals(prodotti.isEmpty(), false);
		assertEquals(prodotti.contains(P1), true);
		assertEquals(prodotti.get(0).getCode(), "01");
		Query deleteQuery=em.createNativeQuery("DELETE FROM Product");
		tx.begin();
		assertEquals(2, deleteQuery.executeUpdate());
		tx.commit();
		
	}

}
