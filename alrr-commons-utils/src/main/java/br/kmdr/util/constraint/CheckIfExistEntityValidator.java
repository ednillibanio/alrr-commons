package br.kmdr.util.constraint;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Named
public class CheckIfExistEntityValidator implements
		ConstraintValidator<CheckIfExistEntity, Object> {

	/**
	 * Nome da query que será executada.
	 */
	private String namedQuery;
	/**
	 * Coluna da tabela que será verificado se já existe.
	 */
	private String columnName;

	@PersistenceContext
	private EntityManager em;

	public void initialize(CheckIfExistEntity unique) {
		this.namedQuery = unique.namedQuery();
		this.columnName = unique.columnName();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		final Query q = em.createNamedQuery(namedQuery);
		q.setParameter(this.columnName, value.toString().toUpperCase());
		return (q.getResultList().size() == 0);
	}
}
