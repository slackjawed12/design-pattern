package vendingmachine;

public class VendingMachine {
    State state;
    Drinking drinking;
    MoneyBox moneyBox;

    VendingMachine(int stock, int price) {
        this.drinking = new Drinking();
        this.drinking.stock = stock;
        this.drinking.price = price;
        this.moneyBox = new MoneyBox();
        this.state = getNoMoneyState();
    }

    void setState(State state) {
        this.state = state;
    }

    void insertMoney(int money) {
        if (money < 0) {
            System.out.println("잘못된 금액 입력");
        } else {
            state.insertCoin(money, this);
        }
    }

    void pushButton() {
        state.pushButton(this);
    }

    void returnMoney() {
        state.returnCoin(this);
    }

    public State getNoMoneyState() {
        return new NoMoneyState();
    }

    public State getNoEnoughMoneyState() {
        return new NoEnoughMoneyState();
    }

    public State getEnoughMoneyState() {
        return new EnoughMoneyState();
    }

    public State getSoldOutState() {
        return new SoldOutState();
    }

    public Drinking getDrinking() {
        return drinking;
    }

    public MoneyBox getMoneyBox() {
        return moneyBox;
    }
}
