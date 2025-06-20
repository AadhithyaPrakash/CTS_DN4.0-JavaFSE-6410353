import java.util.*;

class SearchProduct {
    int productId;
    String productName;
    String category;

    public SearchProduct(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }
}

public class SearchFunction {
    static SearchProduct linearSearch(SearchProduct[] products, String name) {
        for (SearchProduct p : products) {
            if (p.productName.equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    static SearchProduct binarySearch(SearchProduct[] products, String name) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        SearchProduct[] items = {
            new SearchProduct(1, "Phone", "Electronics"),
            new SearchProduct(2, "Tablet", "Electronics"),
            new SearchProduct(3, "Watch", "Accessories")
        };

        Arrays.sort(items, Comparator.comparing(p -> p.productName));

        SearchProduct result = binarySearch(items, "Watch");
        if (result != null)
            System.out.println("Found: " + result.productName);
        else
            System.out.println("Not Found");
    }
}

