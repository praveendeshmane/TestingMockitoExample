package in.co.praveendeshmane.blog.testingmockitoexample;

import java.util.HashMap;

public class RealWarehouse implements Warehouse {

    private HashMap<String, Integer> products;

    public RealWarehouse() {
        products = new HashMap<String, Integer>();
        products.put("Talisker", 5);
        products.put("Lagavulin", 2);
    }

    public boolean hasInventory(String product, int quantity) {
        return inStock(product) >= quantity;
    }

    public void remove(String product, int quantity) {
        products.put(product, inStock(product) - quantity);
    }

    private int inStock(String product) {
        Integer quantity = products.get(product);
        return quantity == null ? 0 : quantity;
    }


}
