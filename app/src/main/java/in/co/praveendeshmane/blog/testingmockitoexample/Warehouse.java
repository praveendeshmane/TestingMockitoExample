package in.co.praveendeshmane.blog.testingmockitoexample;

public interface Warehouse {
    boolean hasInventory(String product, int quantity);
    void remove(String product, int quantity);
}
