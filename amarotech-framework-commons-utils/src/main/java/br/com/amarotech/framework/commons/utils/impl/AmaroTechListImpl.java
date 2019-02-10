package br.com.amarotech.framework.commons.utils.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.amarotech.framework.commons.exceptions.AmaroTechItemNotFoundException;
import br.com.amarotech.framework.commons.functions.AmaroTechWherePredicate;
import br.com.amarotech.framework.commons.utils.AmaroTechList;
import br.com.amarotech.framework.commons.utils.AmaroTechResourceBundle;

/**
 * List of items
 * @author mamaro
 *
 * @param <T> Any Object
 */
public class AmaroTechListImpl<T> extends ArrayList<T> implements AmaroTechList<T> {
	private static final long serialVersionUID = -4367029391093859344L;
	
	private static AmaroTechResourceBundle bundle = AmaroTechResourceBundleImpl.getInstance();
	
	private static final String EXCEPTION_BUNDLE = "AmaroTechExceptionBundle";
	private static final String FIND_ITEM_EXCEPTION_CODE = "ItemNotFound";

	private int pageSize;
	private int totalPages;
	
	public AmaroTechListImpl() {
		super();
	}
	public AmaroTechListImpl(List<T> list) {
		super(list);
	}
	public AmaroTechListImpl(int pageSize, int totalPages) {
		this.pageSize = pageSize;
		this.totalPages = totalPages;
	}
	
	@Override
	public AmaroTechList<T> where(AmaroTechWherePredicate<T> predicate) {
		AmaroTechList<T> list = new AmaroTechListImpl<T>();
		for (T item : this) {
			if (predicate.test(item)) {
				list.add(item);
			}
		}
		
		return list;
	}
	
	@Override
	public T findFirst(AmaroTechWherePredicate<T> predicate) throws AmaroTechItemNotFoundException {
		for (T item : this) {
			if (predicate.test(item)) {
				return item;
			}
		}
		
		throw new AmaroTechItemNotFoundException(
			bundle.getLabel(EXCEPTION_BUNDLE, FIND_ITEM_EXCEPTION_CODE)
		);
	}
	
	@Override
	public T findLast(AmaroTechWherePredicate<T> predicate) throws AmaroTechItemNotFoundException {
		AmaroTechList<T> list = this.reverse();
		for (T item : list) {
			if (predicate.test(item)) {
				return item;
			}
		}
		
		throw new AmaroTechItemNotFoundException(
			bundle.getLabel(EXCEPTION_BUNDLE, FIND_ITEM_EXCEPTION_CODE)
		);
	}
	
	@Override
	public boolean isNotEmpty() {
		return !this.isEmpty();
	}
	
	@Override
	public boolean isExists(AmaroTechWherePredicate<T> predicate) {
		for (T item : this) {
			if (predicate.test(item)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public AmaroTechList<T> reverse() {
		Collections.reverse(this);
		return this;
	}
	
	@Override
	public int getPageSize() {
		return pageSize;
	}
	
	@Override
	public int getTotalPages() {
		return totalPages;
	}
}