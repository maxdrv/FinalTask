package ozon.util;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    private static Map<String, Object> stash = new HashMap<>();

    public static Map<String, Object> getStash() {
        return stash;
    }


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
