package br.com.ufcg.easymocktests.configurations;

import br.com.ufcg.easymocktests.models.RandomJokeResponse;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "mocktestsapi", url = "${mocktestsapi.url}")
public interface RandomJokeClient {

    RandomJokeResponse getRandomJoke();
}
