package br.com.ufcg.easymocktests.classes;

public enum Operation {
    GET("get"),
    POST("post"),
    PUT("put"),
    DELETE("delete"),
    PATCH("patch");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }
}
