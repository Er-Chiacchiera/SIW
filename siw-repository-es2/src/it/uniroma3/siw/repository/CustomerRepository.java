package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.siw.model.Customer;



public class CustomerRepository {

	private EntityManager em;

	public Customer save(Customer customer) {
		if (customer.getId() != null)
			em.merge(customer);
		else em.persist(customer);

		return customer;
	}

	public Customer findById(Long id) {
		return em.find(Customer.class, id);
	}

	public List<Customer> findAll() {
		return em.createQuery("select p from Customer p", Customer.class).getResultList();
	}

	public void delete(Customer customer) {
		em.remove(customer);
	}

	public void deleteAll(){
		this.em.createQuery("delete from Customer").executeUpdate();
	}

	public long count() {
		return (Long)this.em.createQuery("select count(id) from Customer").getSingleResult();
	}

	public boolean existsById(Long id) {
		return (this.findById(id)!=null);
	}

	public void setEntityManager(EntityManager em) {
		this.em = em; 
	}
}

