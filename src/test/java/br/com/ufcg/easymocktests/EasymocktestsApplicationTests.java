package br.com.ufcg.easymocktests;

import br.com.ufcg.easymocktests.classes.Authentication;
import br.com.ufcg.easymocktests.interfaces.Authenticate;
import br.com.ufcg.easymocktests.interfaces.AuthenticatedTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@EnableAutoConfiguration
@AutoConfigureMockMvc
class EasymocktestsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MockTest mockTest;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void verifyProgress() {
		Authentication.verifyMethodLoginImplement(this);
		Authentication.verifyTestsUsingAnnotation(this);
	}

	@Authenticate
	void login() throws Exception {


		mockMvc.perform(post("URL").contentType("application/json").content(objectMapper.writeValueAsString(""))).andExpect(status().isOk());
		System.out.println("logando...");
	}

	@AuthenticatedTest
	void test01() {
		System.out.println("test 01 - sucess");
	}

	@AuthenticatedTest
	void test02() {
		System.out.println("test 02 - sucess");
	}

	@AuthenticatedTest
	@Test
	void test03() {
		System.out.println("test 03 - sucess");
	}
}
