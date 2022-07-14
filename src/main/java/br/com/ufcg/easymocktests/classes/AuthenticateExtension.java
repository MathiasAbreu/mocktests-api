package br.com.ufcg.easymocktests.classes;

import br.com.ufcg.easymocktests.interfaces.Authenticate;
import br.com.ufcg.easymocktests.interfaces.AuthenticatedTest;
//import br.com.ufcg.easymocktests.interfaces.AuthenticatedTest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AuthenticateExtension implements ConstraintValidator<Authenticate, Object> {

    public static void verifyMethodLoginImplement(Object obj) {
        try {
            Class clazz = obj.getClass();
            for (Method m : clazz.getDeclaredMethods()) {
                if(m.isAnnotationPresent(Authenticate.class)) {
                    m.setAccessible(true);
                    System.out.println(m.invoke(obj));
                    System.out.println(m);
                }
            }
        } catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean methodLoginIsImplement(Object object) {

        try {

            Class<?> c = object.getClass();
            for (Method method : c.getDeclaredMethods()) {

                if(method.isAnnotationPresent(Authenticate.class))
                    return true;
            }
            return false;
        } catch (SecurityException e) {
            return false;
        }
    }

    public static void verifyTestsUsingAnnotation(Object obj) {

        try {
            Class clazz = obj.getClass();
            for(Method m : clazz.getDeclaredMethods()) {
                if(m.isAnnotationPresent(AuthenticatedTest.class)) {
                    m.setAccessible(true);
                    System.out.println(m);
                    System.out.println(m.invoke(obj));
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
