package vendingmachine;

public interface State {
    void insertCoin(int x, VendingMachine vm);
    void pushButton(VendingMachine vm);
    void returnCoin(VendingMachine vm);
}
