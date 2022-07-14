package br.com.ufcg.easymocktests;

import br.com.ufcg.easymocktests.classes.Operation;
import br.com.ufcg.easymocktests.classes.Request;
import br.com.ufcg.easymocktests.classes.TypeHeader;
import br.com.ufcg.easymocktests.interfaces.Authenticate;
import br.com.ufcg.easymocktests.interfaces.AuthenticatedTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@EnableAutoConfiguration
@AutoConfigureMockMvc
class EasymocktestsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private final MockTest mockTest = new MockTest(this);

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void verifyProgress() {
		AuthenticateExtension.verifyMethodLoginImplement(this);
		AuthenticateExtension.verifyTestsUsingAnnotation(this);
	}

	@Authenticate
	ResultActions login() throws Exception {

		return mockMvc.perform(post("URL").contentType("application/json").content(objectMapper.writeValueAsString(""))).andExpect(status().isOk());
		//System.out.println("logando...");
		//mockTest.request(Request.params("parametro1"));
	}

	@Test
	void test01() throws Exception {

		Request request = new Request();
		request.operation(Operation.GET)
				.endpoint("ENDPOINT")
				.header("Authorization", TypeHeader.BEARER,"TOKEN")
				.params("1234").contentType("application/json").body("body");
		mockTest.performTest(request);
	}

	@Test
	void test02() throws Exception {
		mockTest.performTest(2);
	}

	@Test
	void test03() throws Exception {
		mockTest.performTest(3);
	}
}
