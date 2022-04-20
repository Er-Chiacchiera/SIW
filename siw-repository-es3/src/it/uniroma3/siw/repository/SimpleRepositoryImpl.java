package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.EntityManager;

public class SimpleRepositoryImpl<T> implements SimpleRepository<T> {

	private EntityManager em;
	private Class<T> domainClass;

	public SimpleRepositoryImpl(Class<T> domainClass) {
		this.domainClass = domainClass;
	}

	public T save(T entity) {
		T persistentEntity = null;
		//TODO (esercizio)
		 return persistentEntity;
	}

	public List<T> findAll() {
		return em.createQuery("select o from " + this.domainClass.getName() + " o", this.domainClass).getResultList();
	}	

	public T findById(Long id){
		return em.find(this.domainClass, id); 
	}

	public void delete(T t){
		this.em.remove(t);
	}

	public void deleteAll(){
		this.em.createQuery("DELETE FROM "+this.domainClass.getName()).executeUpdate();
	}

	public long count() {
		return (long)this.em.createQuery("SELECT COUNT(id) FROM "+this.domainClass.getName()).getSingleResult();
	}

	public boolean existsById(Long id) {
		return (this.findById(id)!=null);
	}

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEntityManager(EntityManager em) {
		
		
	}
}