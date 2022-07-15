package br.com.ufcg.easymocktests.annotations;

import br.com.ufcg.easymocktests.configurations.MockTestsApiClienteConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MockTestsApiClienteConfiguration.class)
public @interface EnableMockTestsApi {
}
