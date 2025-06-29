import java.util.*;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int id, String name, int qty, double price) {
        this.productId = id;
        this.productName = name;
        this.quantity = qty;
        this.price = price;
    }
}

class Inventory {
    HashMap<Integer, Product> products = new HashMap<>();

    void addProduct(Product p) {
        products.put(p.productId, p);
    }

    void updateProduct(int id, int newQty, double newPrice) {
        if (products.containsKey(id)) {
            Product p = products.get(id);
            p.quantity = newQty;
            p.price = newPrice;
        }
    }

    void deleteProduct(int id) {
        products.remove(id);
    }

    void displayInventory() {
        for (Product p : products.values()) {
            System.out.println("ID: " + p.productId + ", Name: " + p.productName +
                    ", Qty: " + p.quantity + ", Price: ₹" + p.price);
        }
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "Mouse", 10, 299.99));
        inv.addProduct(new Product(2, "Keyboard", 5, 499.99));
        inv.displayInventory();
    }
}
