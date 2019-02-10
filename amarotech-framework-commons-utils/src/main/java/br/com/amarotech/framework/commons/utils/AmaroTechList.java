package br.com.amarotech.framework.commons.utils;

import java.util.List;

import br.com.amarotech.framework.commons.exceptions.AmaroTechItemNotFoundException;
import br.com.amarotech.framework.commons.functions.AmaroTechWherePredicate;

public interface AmaroTechList<T> extends List<T> {
	/**
	 * Find where lambda expressions.
	 * @param predicate
	 * @return
	 */
	public AmaroTechList<T> where(AmaroTechWherePredicate<T> predicate);
	
	/**
	 * Find first item in lambda expressions
	 * @param predicate
	 * @return
	 * @throws AmaroTechItemNotFoundException When you can't find any items.
	 */
	public T findFirst(AmaroTechWherePredicate<T> predicate) throws AmaroTechItemNotFoundException;
	
	/**
	 * Find last item in lambda expressions
	 * @param predicate
	 * @return
	 * @throws AmaroTechItemNotFoundException When you can't find any items.
	 */
	public T findLast(AmaroTechWherePredicate<T> predicate) throws AmaroTechItemNotFoundException;
	
	/**
	 * Checks if the list is not empty.
	 * @return
	 */
	public boolean isNotEmpty();
	
	/**
	 * Checks if there is any item in the list.
	 * @param predicate
	 * @return
	 */
	public boolean isExists(AmaroTechWherePredicate<T> predicate);
	
	/**
	 * Reverse list.
	 * @return
	 */
	public AmaroTechList<T> reverse();
	
	/**
	 * Returns page size
	 * @return
	 */
	public int getPageSize();
	
	/**
	 * Returns total page
	 * @return
	 */
	public int getTotalPages();
}