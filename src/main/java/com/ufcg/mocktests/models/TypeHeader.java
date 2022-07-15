package com.ufcg.mocktests.models;

public enum TypeHeader {
    BEARER("Bearer");

    private String typeHeader;

    TypeHeader(String typeHeader) {
        this.typeHeader = typeHeader;
    }
}
