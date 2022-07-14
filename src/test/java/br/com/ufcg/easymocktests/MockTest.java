package br.com.ufcg.easymocktests;

import br.com.ufcg.easymocktests.classes.*;
import com.fasterxml.jackson.databind.ObjectMapper;
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
                ResultActions resultLogin = authenticateExtension.invokeMethodLogin(object);
                if(resultLogin.andReturn().getResponse().getStatus() > 200 && resultLogin.andReturn().getResponse().getStatus() < 300) {
                    String token = resultLogin.andReturn().getResponse().getContentAsString();
                    String[] values = token.split(" ");
                    return mockMvc.perform(convertOperation(request.getOperation(), request.getEndpoint(), request.getParams())
                            .header(values[0], values[1], values[2])
                            .contentType(request.getContentType())
                            .content(objectMapper.writeValueAsString(request.getBody())));
                }
                else
                    throw new IllegalAccessException("Username or password invalid! - LOGIN FAILED");
            }
        }

        if(request.getHeader().getNoHeader()) {
            return mockMvc.perform(convertOperation(request.getOperation(), request.getEndpoint(), request.getParams())
                    .contentType(request.getContentType())
                    .content(objectMapper.writeValueAsString(request.getBody())));
        }

        return mockMvc.perform(convertOperation(request.getOperation(), request.getEndpoint(), request.getParams())
                .header(request.getHeader().getName(), convertTypeHeaders(request.getHeader()))
                .contentType(request.getContentType())
                .content(objectMapper.writeValueAsString(request.getBody())));
    }

    private String convertTypeHeaders(Header header) {

        if(header.getTypeHeader().equals(TypeHeader.BEARER))
            return String.format("%s %s",header.getTypeHeader().name(), header.getValues()[0]);

        return "NOT IMPLEMENTED";
    }
    private MockHttpServletRequestBuilder convertOperation(Operation operation, String endpoint, Object[] params) {

        if(operation.equals(Operation.GET)) {
            if(params == null || params.length == 0)
                return get(endpoint);
            return get(endpoint, params);
        }

        if(operation.equals(Operation.POST)) {
            if(params == null || params.length == 0)
                return post(endpoint);
            return post(endpoint, params);
        }

        if(operation.equals(Operation.PUT)) {
            if(params == null || params.length == 0)
                return put(endpoint);
            return put(endpoint, params);
        }

        if(operation.equals(Operation.DELETE)) {
            if(params == null || params.length == 0)
                return delete(endpoint);
            return delete(endpoint, params);
        }

        if(params == null || params.length == 0)
            return patch(endpoint);
        return patch(endpoint, params);
    }

    public void performTest(int countTests) throws Exception {
        System.out.println("Teste nº 0" + countTests);
        //mockMvc.perform(get("localhost:8080/hello"));
    }
    /*public ResultActions request(RequestBuilder requestBuilder) throws Exception {

    }*/
}
