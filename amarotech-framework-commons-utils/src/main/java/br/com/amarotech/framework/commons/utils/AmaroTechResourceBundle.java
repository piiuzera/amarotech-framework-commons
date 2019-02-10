package br.com.amarotech.framework.commons.utils;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

public interface AmaroTechResourceBundle extends Serializable {
	public ResourceBundle getBundle(String bundleName);
	public ResourceBundle getBundle(String bundleName, Locale locale);
	public String getLabel(String bundleName, String code);
	public String getLabel(String bundleName, String code, Locale locale);
}