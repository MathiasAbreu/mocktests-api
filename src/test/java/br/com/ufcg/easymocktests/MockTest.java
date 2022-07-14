package br.com.ufcg.easymocktests;

import br.com.ufcg.easymocktests.classes.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

//@SpringBootTest
@EnableAutoConfiguration
@AutoConfigureMockMvc
public class MockTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //classe alvo
    private Object object;

    private final AuthenticateExtension authenticateExtension = new AuthenticateExtension();

    public MockTest(Object object) {
        super();
        this.object = object;
    }

    public ResultActions performTest(Request request) throws Exception {

        if(request.getHeader() == null) {
            if(authenticateExtension.methodLoginIsImplement(object)) {

            }
        }
        
        return mockMvc.perform(convertOperation(request.getOperation(), request.getEndpoint(), request.getParams())
                .header(request.getHeader().getName(), convertTypeHeaders(request.getHeader().getTypeHeader()) + request.getHeader().getValues())
                .contentType(request.getContentType())
                .content(objectMapper.writeValueAsString(request.getBody())));
    }

    private String convertTypeHeaders(TypeHeader typeHeader) {

        if(typeHeader.equals(TypeHeader.BEARER))
            return typeHeader.name();

        return "";
    }
    private MockHttpServletRequestBuilder convertOperation(Operation operation, String endpoint, Object[] params) {

        if(operation.equals(Operation.GET)) {
            return get(endpoint, params);
        }

        if(operation.equals(Operation.POST)) {
            return post(endpoint, params);
        }

        if(operation.equals(Operation.PUT)) {
            return put(endpoint, params);
        }

        if(operation.equals(Operation.DELETE)) {
            return delete(endpoint, params);
        }

        return patch(endpoint, params);
    }

    public void performTest(int countTests) throws Exception {
        System.out.println("Teste nº 0" + countTests);
        //mockMvc.perform(get("localhost:8080/hello"));
    }
    /*public ResultActions request(RequestBuilder requestBuilder) throws Exception {

    }*/
}
