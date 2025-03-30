package com.judge.auth.util;

import java.lang.reflect.Field;

public class Helpers {
	static public Boolean isInRange(String str, Integer minLength, Integer maxLength) {
		return (minLength <= str.length() && str.length() <= maxLength);
	}

	static public Object getFieldValue(Field field, Object object) throws IllegalAccessException {
		field.setAccessible(true);
		return field.get(object);
	}

}
