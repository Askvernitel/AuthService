package com.judge.auth.services.validation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.Annotation;

import org.springframework.stereotype.Service;

import com.judge.auth.annotations.Validate;
import com.judge.auth.exceptions.base.ValidationException;
import com.judge.auth.util.Helpers;

@Service
public class ValidationService {

	private Boolean isValidFieldLength(Field field, Object object) {
		try {
			int maxLength = field.getAnnotation(Validate.class).maxLength();
			int minLength = field.getAnnotation(Validate.class).minLength();
			Object value = Helpers.getFieldValue(field, object);
			if (!(value instanceof String))
				return false;
			String strValue = (String) value;

			return Helpers.isInRange(strValue, minLength, maxLength);
		} catch (Exception e) {
			return false;
		}
	}

	private Boolean isValidFieldRequired(Field field, Object object) {
		try {
			Boolean required = field.getAnnotation(Validate.class).required();
			Object value = Helpers.getFieldValue(field, object);
			if (value == null && required)
				return false;
			return true;
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
		return isValidFieldLength(field, object) && isValidFieldRequired(field, object);

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
