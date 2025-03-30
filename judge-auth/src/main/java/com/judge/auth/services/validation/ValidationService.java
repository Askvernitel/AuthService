package com.judge.auth.services.validation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.Annotation;

import org.springframework.stereotype.Service;

import com.judge.auth.annotations.Validate;
import com.judge.auth.exceptions.base.ValidationException;

@Service
public class ValidationService {

	private Object getFieldValue(Field field, Object object) throws IllegalAccessException {
		field.setAccessible(true);
		return field.get(object);
	}

	private Boolean isInRange(String str, Integer minLength, Integer maxLength) {
		return (minLength <= str.length() && str.length() <= maxLength);
	}

	private Boolean isValidLength(Field field, Object object) {
		try {
			int maxLength = field.getAnnotation(Validate.class).maxLength();
			int minLength = field.getAnnotation(Validate.class).minLength();
			Object value = getFieldValue(field, object);
			if (!(value instanceof String))
				return false;
			String strValue = (String) value;

			return isInRange(strValue, minLength, maxLength);
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * private Boolean isValidEmail(Field field, Object object) {
	 * try {
	 * 
	 * } catch (Exception e) {
	 * return false;
	 * }
	 * }
	 */

	private Boolean isValidField(Field field, Object object) throws IllegalAccessException {

		return isValidLength(field, object);

	}

	public Boolean isValid(Object object) throws ValidationException, Exception {
		if (object == null) {
			throw new ValidationException("BAD_CREDENTIALS");
		}

		Class<?> clazz = object.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(Validate.class)) {
				if (!isValidField(field, object)) {
					throw new ValidationException("BAD_FIELDS");
				}
			}
		}
		return true;
	}
}
