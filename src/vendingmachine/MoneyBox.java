package vendingmachine;

public class MoneyBox {
    int money;

    int getMoney() {
        return money;
    }

    void insert(int money) {
        this.money += money;
    }

    void dispense(int price) {
        this.money -= price;
    }

    int returnMoney() {
        int m = this.money;
        this.money = 0;
        return m;
    }
}
