package vendingmachine;

public class SoldOutState implements State{

    @Override
    public void insertCoin(int x, VendingMachine vm) {
        MoneyBox moneyBox = vm.getMoneyBox();
        moneyBox.insert(x);
        System.out.println("재고가 없어 금액을 반환하겠습니다.");
        returnCoin(vm);
    }

    @Override
    public void pushButton(VendingMachine vm) {
        System.out.println("재고가 없습니다.");
    }

    @Override
    public void returnCoin(VendingMachine vm) {
        MoneyBox moneyBox = vm.getMoneyBox();
        moneyBox.returnMoney();
    }
}
