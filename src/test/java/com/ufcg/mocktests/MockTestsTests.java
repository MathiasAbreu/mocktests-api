package com.ufcg.mocktests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@EnableAutoConfiguration
@AutoConfigureMockMvc
class MockTestsTests {

	@Test
	void contextLoads() {
	}

}
