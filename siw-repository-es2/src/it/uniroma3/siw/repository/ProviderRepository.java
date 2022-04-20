package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.siw.model.Provider;



public class ProviderRepository {

	private EntityManager em;

	public Provider save(Provider provider) {
		if (provider.getId() != null)
			em.merge(provider);
		else em.persist(provider);

		return provider;
	}

	public Provider findById(Long id) {
		return em.find(Provider.class, id);
	}

	public List<Provider> findAll() {
		return em.createQuery("select p from Provider p", Provider.class).getResultList();
	}

	public void delete(Provider provider) {
		em.remove(provider);
	}

	public void deleteAll(){
		this.em.createQuery("delete from Provider").executeUpdate();
	}

	public long count() {
		return (Long)this.em.createQuery("select count(id) from Provider").getSingleResult();
	}

	public boolean existsById(Long id) {
		return (this.findById(id)!=null);
	}

	public void setEntityManager(EntityManager em) {
		this.em = em; 
	}
}

