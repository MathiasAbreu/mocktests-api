package br.com.ufcg.easymocktests;

import br.com.ufcg.easymocktests.classes.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//@SpringBootTest
@EnableAutoConfiguration
@AutoConfigureMockMvc
public class MockTest {

    @Autowired
    private MockMvc mockMvc;

    public void performTest(int countTests) throws Exception {
        System.out.println("Teste nº 0" + countTests);
        //mockMvc.perform(get("localhost:8080/hello"));
    }
    /*public ResultActions request(RequestBuilder requestBuilder) throws Exception {

    }*/
}
