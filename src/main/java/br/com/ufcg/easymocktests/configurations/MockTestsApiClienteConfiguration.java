package br.com.ufcg.easymocktests.configurations;

import br.com.ufcg.easymocktests.proxy.MockTestsApiClientProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@EnableFeignClients(clients = RandomJokeClient.class)
@ComponentScan(basePackageClasses = MockTestsApiClientProxy.class)
@Configuration
@PropertySource(value = "classpath:application.yaml")
public class MockTestsApiClienteConfiguration {
}
