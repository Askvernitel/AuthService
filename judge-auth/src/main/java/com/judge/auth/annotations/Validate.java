package com.judge.auth.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Validate {
	public int maxLength() default Integer.MAX_VALUE;

	public int minLength() default Integer.MIN_VALUE;

	public boolean required() default false;

	public boolean email() default false;

}
