package br.com.ufcg.easymocktests;

import br.com.ufcg.easymocktests.interfaces.Authenticate;
import br.com.ufcg.easymocktests.interfaces.AuthenticatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EasymocktestsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Authenticate
	void login() {
		System.out.println("loggando...");
	}

	@AuthenticatedTest
	void test01() {

	}
}
