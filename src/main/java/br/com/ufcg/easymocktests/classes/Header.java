package br.com.ufcg.easymocktests.classes;

public class Header {

    private static String name;

    private static TypeHeader typeHeader;

    private static String[] values;

    Header(String name, TypeHeader typeHeader, String... values) {
        Header.name = name;
        Header.typeHeader = typeHeader;
        Header.values = values;
    }
}
