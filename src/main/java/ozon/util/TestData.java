package ozon.util;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    
    public static String getDescriprionItem() {
        return descriprionItem;
    }

    public static void setDescriprionItem(String descriprionItem) {
        TestData.descriprionItem = descriprionItem;
    }

    public static int getPriceItem() {
        return priceItem;
    }

    public static void setPriceItem(int priceItem) {
        TestData.priceItem = priceItem;
    }

    private static String descriprionItem;
    private static int priceItem;

}
