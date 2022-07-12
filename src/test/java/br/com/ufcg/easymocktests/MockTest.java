package br.com.ufcg.easymocktests;

import br.com.ufcg.easymocktests.classes.Operation;
import br.com.ufcg.easymocktests.classes.Request;
import br.com.ufcg.easymocktests.classes.TypeHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

//@SpringBootTest
@EnableAutoConfiguration
@AutoConfigureMockMvc
public class MockTest {

    @Autowired
    private MockMvc mockMvc;

    public void request(Request request) throws Exception {
        Request.operation(Operation.GET);
        Request.endpoint("ENDPOINT");
        Request.header("Authorization", TypeHeader.BEARER,"TOKEN");
    }
}
