package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "mocktests_library")
@PropertySource("classpath:lib/src/main/config")
public class MockTestsConfiguration {
}
