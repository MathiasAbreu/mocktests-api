package br.com.ufcg.easymocktests.classes;

public class Header {

    private static String name;

    private static TypeHeader typeHeader;

    private static String[] values;

    private static boolean noHeader;

    Header(String name, TypeHeader typeHeader, String... values) {
        Header.name = name;
        Header.typeHeader = typeHeader;
        Header.values = values;
    }

    Header(boolean noHeader) {
        Header.noHeader = noHeader;
    }

    public String getName() {
        return name;
    }

    public TypeHeader getTypeHeader() {
        return typeHeader;
    }

    public String[] getValues() {
        return values;
    }

    public boolean getNoHeader() {
        return noHeader;
    }
}
