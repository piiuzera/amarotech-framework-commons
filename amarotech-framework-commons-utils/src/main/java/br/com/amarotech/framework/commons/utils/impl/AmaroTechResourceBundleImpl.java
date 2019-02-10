package br.com.amarotech.framework.commons.utils.impl;

import java.util.Locale;
import java.util.ResourceBundle;

import br.com.amarotech.framework.commons.utils.AmaroTechResourceBundle;

public class AmaroTechResourceBundleImpl implements AmaroTechResourceBundle {
	private static final long serialVersionUID = -1839697297825404013L;
	
	private AmaroTechResourceBundleImpl() {
		super();
	}
	
	private static AmaroTechResourceBundleImpl instance;
	public static AmaroTechResourceBundleImpl getInstance() {
		if (instance == null) {
			instance = new AmaroTechResourceBundleImpl();
		}
		
		return instance;
	}
	
	public ResourceBundle getBundle(String bundleName) {
		return ResourceBundle.getBundle(bundleName);
	}
	
	public ResourceBundle getBundle(String bundleName, Locale locale) {
		return ResourceBundle.getBundle(bundleName, locale);
	}
	
	public String getLabel(String bundleName, String code) {
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName);
		return bundle.getString(code);
	}
	
	public String getLabel(String bundleName, String code, Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale);
		return bundle.getString(code);
	}
}