package com.wpsnetwork.pcarrier.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

public abstract class AnnotationUtils {

	public static <T extends Annotation> Collection<Field> getAnnotatedFields( Object o, Class<T> c ) {
		Collection<Field> annotatedFields = new ArrayList<>();
		T[] foundAnnotations;
		for (Class<?> sc = o.getClass(); sc != null; sc = sc.getSuperclass()) {
			Field[] fields = sc.getDeclaredFields();
			for (Field classField : fields) {
				foundAnnotations = classField.getDeclaredAnnotationsByType(c);
				if( foundAnnotations.length > 0 )
				annotatedFields.add(classField);
			}
		}
		return annotatedFields;
	}
}
