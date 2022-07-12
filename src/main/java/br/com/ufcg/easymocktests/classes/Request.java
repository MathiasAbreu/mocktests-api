package br.com.ufcg.easymocktests.classes;

public final class Request {

    private static Operation operation;

    private static String endpoint;

    private static Header header;

    private static String[] params;

    private static String contentType;

    private static Object body;

    public static void operation(Operation operation) {
        Request.operation = operation;
    }

    public static void endpoint(String endpoint) {
        Request.endpoint = endpoint;
    }

    public static void header(String name, TypeHeader typeHeader, String... values) {
        Request.header = new Header(name, typeHeader, values);
    }
}
