package com.ufcg.mocktests.utils;

import com.ufcg.mocktests.extensions.AuthenticateExtension;
import org.api.mocktests.extensions.AuthenticatedTestExtension;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.api.mocktests.models.Header;
import org.api.mocktests.models.Operation;
import org.api.mocktests.models.Request;
import org.api.mocktests.models.TypeHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@EnableAutoConfiguration
@AutoConfigureMockMvc
public class MockTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //classe alvo
    private static Object object;

    private final AuthenticateExtension authenticateExtension = new AuthenticateExtension();
    private final AuthenticatedTestExtension authenticatedTestExtension = new AuthenticatedTestExtension(object);

    public MockTest(Object object) {
        super();
        MockTest.object = object;
    }
    public ResultActions performTest(Request request) throws Exception {

        if(request.getHeader() == null) {
            if(authenticateExtension.methodLoginIsImplement(object)) {

                String[] methodsStack = authenticatedTestExtension.getMethods();
                List<String> methodsAuthenticatedTest = authenticatedTestExtension.getMethodsAuthenticatedTest(object);

                if(methodsAuthenticatedTest.contains(methodsStack[3])) {

                    ResultActions resultLogin = authenticateExtension.invokeMethodLogin(object);
                    if (resultLogin.andReturn().getResponse().getStatus() > 200 && resultLogin.andReturn().getResponse().getStatus() < 300) {
                        String token = resultLogin.andReturn().getResponse().getContentAsString();
                        String[] values = token.split(" ");
                        return mockMvc.perform(convertOperation(request.getOperation(), request.getEndpoint(), request.getParams())
                                .header(values[0], values[1], values[2])
                                .contentType(request.getContentType())
                                .content(objectMapper.writeValueAsString(request.getBody())));
                    } else
                        throw new IllegalAccessException("Username or password invalid! - LOGIN FAILED");
                }
            }
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
}
