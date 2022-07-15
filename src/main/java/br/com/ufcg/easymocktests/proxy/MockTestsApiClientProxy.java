package br.com.ufcg.easymocktests.proxy;

import br.com.ufcg.easymocktests.configurations.RandomJokeClient;
import br.com.ufcg.easymocktests.models.MockTestsApiClientResponse;
import br.com.ufcg.easymocktests.models.RandomJokeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MockTestsApiClientProxy {

    private final RandomJokeClient randomJokeClient;

    public MockTestsApiClientResponse<RandomJokeResponse> getRandomJoke() {

        RandomJokeResponse response;
        try {
            response = randomJokeClient.getRandomJoke();
        } catch (Exception exception) {
            return getErrorResponse(exception.getMessage());
        }

        if(response == null)
            return getErrorResponse("RandomJokeClient returned null response!");

        log.info("getRandomJoke request received. Response: {}", response);

        return MockTestsApiClientResponse.<RandomJokeResponse>builder().data(response).build();

    }

    private MockTestsApiClientResponse<RandomJokeResponse> getErrorResponse(String errorDescription) {
        log.info("getRandomJoke request received but an error occurred. Error: {}", errorDescription);
        return MockTestsApiClientResponse.<RandomJokeResponse>builder().error(true).errorDescription(errorDescription).build();
    }
}
