package br.com.bmt.reports.converters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RestConverter {
	
	/** The type of the DTO manipulated by the REST converter */
	String dto();

}
