package br.com.ufcg.easymocktests.interfaces;

import br.com.ufcg.easymocktests.classes.Authentication;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Authentication.class)
public @interface Authenticate {
}
