package com.judge.auth.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Helpers {
	static public Boolean isInRange(String str, Integer minLength, Integer maxLength) {
		return (minLength <= str.length() && str.length() <= maxLength);
	}

	static public Object getFieldValue(Field field, Object object) throws IllegalAccessException {
		field.setAccessible(true);
		return field.get(object);
	}
	static public List<Method> getAllSetters(Object obj){
		Class<?> clazz = obj.getClass();
		List<Method> result = new ArrayList<>();
		for(Method method: clazz.getMethods()) {
			if(method.getName().startsWith("set")) {
				result.add(method);
			}
		}
		return result;
	}
	static public List<Method> getAllGetters(Object obj){
		Class<?> clazz = obj.getClass();
		List<Method> result = new ArrayList<>();
		for(Method method: clazz.getMethods()) {
			if(method.getName().startsWith("get")) {
				result.add(method);
			}
		}
		return result;

	}
	static public void copySameFieldsFromTo(Object from, Object to){
		Class<?> clazz1 = from.getClass();
		Class<?> clazz2 = to.getClass();

		for(Method method1: getAllGetters(from)) {
			for(Method method2: getAllSetters(to)){
				try {
					boolean areSameType = method1.getReturnType().getName().equals(method2.getParameterTypes()[0].getName());
					//TODO: separate this stuff into methods
					boolean haveSameName = method1.getName().substring(3)	.equals(method2.getName().substring(3));
					if (!areSameType) continue;
					if (haveSameName) {
						System.out.println(method2.getName());
						try {
							method2.invoke(to, method1.invoke(from));
						} catch (Exception e) {
							System.out.println(e.getMessage());
							//Unknown Exception
						}
					}
				}catch(Exception e){
					System.out.println(e.getMessage());
					//ignore
				}
			}
		}
	}
}
