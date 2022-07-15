package com.ufcg.mocktests.classes;

public enum TypeHeader {
    BEARER("Bearer");

    private String typeHeader;

    TypeHeader(String typeHeader) {
        this.typeHeader = typeHeader;
    }
}
