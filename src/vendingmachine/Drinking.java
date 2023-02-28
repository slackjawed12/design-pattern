package vendingmachine;

public class Drinking {
    int price;
    int stock;

    void dispense() {
        this.stock--;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
