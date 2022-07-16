package mocktests_library.models;

public enum TypeHeader {
    BEARER("Bearer");

    private String typeHeader;

    TypeHeader(String typeHeader) {
        this.typeHeader = typeHeader;
    }
}
