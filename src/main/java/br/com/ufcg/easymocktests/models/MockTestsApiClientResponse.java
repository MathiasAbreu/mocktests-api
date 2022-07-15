package br.com.ufcg.easymocktests.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MockTestsApiClientResponse<T> {

    private T data;
    private boolean error;
    private String errorDescription;
}
