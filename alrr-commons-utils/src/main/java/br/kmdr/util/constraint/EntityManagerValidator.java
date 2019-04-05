package br.kmdr.util.constraint;

import javax.persistence.EntityManager;

public interface EntityManagerValidator {

	public void setEntityManager(EntityManager em);

	public EntityManager getEntityManager();
}
