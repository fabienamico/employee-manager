package fr.treeptik.employeemanager.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import fr.treeptik.employeemanager.dao.GenericDAO;
import fr.treeptik.employeemanager.exception.DAOException;

@SuppressWarnings("unchecked")
public abstract class GenericJPAImpl<T, PK> implements GenericDAO<T, PK> {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<T> type;
	
	public GenericJPAImpl() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T save(T entite) throws DAOException {
		
		try {
			entityManager.persist(entite);
			return entite;
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
		
	}
	
	@Override
	public T update(T entite) throws DAOException {
		
		try {
			return entityManager.merge(entite);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
		
	}

	@Override
	public void remove(PK id) throws DAOException {
		
		try {
			Query query = entityManager.createQuery("DELETE FROM " + type.getSimpleName() + " t WHERE t.id = :id");
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
		
	}

	@Override
	public T findById(PK id) throws DAOException {
		
		try {
			return entityManager.find(type, id);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
		
	}

	@Override
	public List<T> findAll() throws DAOException {
		
		try {
			return entityManager.createQuery("SELECT t FROM " + type.getSimpleName() + " t", type).getResultList();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
		
	}

}