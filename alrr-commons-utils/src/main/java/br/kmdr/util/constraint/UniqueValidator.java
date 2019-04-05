package br.kmdr.util.constraint;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.PropertyUtils;

@Named
public class UniqueValidator implements ConstraintValidator<Unique, Object> {

	private String[] columnNames;

	@PersistenceContext
	private EntityManager em;

	public void initialize(Unique unique) {
		this.columnNames = unique.columnNames();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Class<?> entityClass = value.getClass();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Object> cq = cb.createQuery();
		final Root<?> root = cq.from(entityClass);
		Predicate predicate;
		final List<Predicate> predicateList = new ArrayList<Predicate>();
		final Query query;

		for (int i = 0; i < columnNames.length; i++) {

			Object propertyValue;
			try {
				propertyValue = PropertyUtils
						.getProperty(value, columnNames[i]);
				final Path<String> p = root.get(columnNames[i]);
				final Expression<String> expression = cb.upper(p);
				predicate = cb.equal(expression, propertyValue.toString()
						.toUpperCase());
				predicateList.add(predicate);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}

		}
		cq.select(root).where(
				predicateList.toArray(new Predicate[predicateList.size()]));
		query = em.createQuery(cq);

		return (query.getResultList().size() == 0);
	}
}
