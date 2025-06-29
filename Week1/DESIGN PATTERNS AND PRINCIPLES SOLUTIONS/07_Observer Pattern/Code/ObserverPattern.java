import java.util.*;

interface Observer {
    void update(String stockName, double price);
}

class MobileApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("Mobile App - " + stockName + " is now ₹" + price);
    }
}

class WebApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("Web App - " + stockName + " is now ₹" + price);
    }
}

class StockMarket {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public StockMarket(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        StockMarket stock = new StockMarket("TCS", 3500);
        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stock.registerObserver(mobile);
        stock.registerObserver(web);

        stock.setPrice(3550);
        stock.setPrice(3600);
    }
}
