class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int id, String name, double price) {
        this.orderId = id;
        this.customerName = name;
        this.totalPrice = price;
    }
}

public class OrderSorting {
    static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println("OrderID: " + o.orderId + ", Name: " + o.customerName + ", Price: ₹" + o.totalPrice);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 1500),
            new Order(2, "Bob", 500),
            new Order(3, "Charlie", 1200)
        };

        System.out.println("Sorted by Bubble Sort:");
        bubbleSort(orders);
        printOrders(orders);

        Order[] newOrders = {
            new Order(4, "David", 1100),
            new Order(5, "Eve", 2000),
            new Order(6, "Frank", 900)
        };

        System.out.println("\nSorted by Quick Sort:");
        quickSort(newOrders, 0, newOrders.length - 1);
        printOrders(newOrders);
    }
}
