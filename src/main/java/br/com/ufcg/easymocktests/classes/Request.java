package br.com.ufcg.easymocktests.classes;

public final class Request {

    private static Operation operation;

    private static String endpoint;

    private static Header header;

    private static Object[] params;

    private static String contentType;

    private static Object body;

    public Request operation(Operation operation) {
        Request.operation = operation;
        return this;
    }

    public Request endpoint(String endpoint) {
        Request.endpoint = endpoint;
        return this;
    }

    public Request header(String name, TypeHeader typeHeader, String... values) {
        Request.header = new Header(name, typeHeader, values);
        return this;
    }

    public Request params(Object... params) {
        Request.params = params;
        return this;
    }

    public Request contentType(String contentType) {
        Request.contentType = contentType;
        return this;
    }

    public Request body(Object body) {
        Request.body = body;
        return this;
    }
}
