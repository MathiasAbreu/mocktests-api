package br.com.ufcg.easymocktests.classes;

import br.com.ufcg.easymocktests.interfaces.Authenticate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Authentication {

    public static void verifyTests(Object obj) {
        try {
            Class clazz = obj.getClass();
            for (Method m : clazz.getDeclaredMethods()) {
                if(m.isAnnotationPresent(Authenticate.class)) {
                    System.out.println(m.invoke(obj));
                }
            }
        } catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
    
}
