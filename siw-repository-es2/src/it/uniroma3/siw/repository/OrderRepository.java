package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.siw.model.Order;



public class OrderRepository {

	private EntityManager em;

	public Order save(Order order) {
		if (order.getId() != null)
			em.merge(order);
		else em.persist(order);

		return order;
	}

	public Order findById(Long id) {
		return em.find(Order.class, id);
	}

	public List<Order> findAll() {
		return em.createQuery("select p from Order p", Order.class).getResultList();
	}

	public void delete(Order order) {
		em.remove(order);
	}

	public void deleteAll(){
		this.em.createQuery("delete from Order").executeUpdate();
	}

	public long count() {
		return (Long)this.em.createQuery("select count(id) from Order").getSingleResult();
	}

	public boolean existsById(Long id) {
		return (this.findById(id)!=null);
	}

	public void setEntityManager(EntityManager em) {
		this.em = em; 
	}
}

