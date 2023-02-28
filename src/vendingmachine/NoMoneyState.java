package vendingmachine;

public class NoMoneyState implements State {

    @Override
    public void insertCoin(int x, VendingMachine vm) {
        Drinking drinking = vm.getDrinking();
        MoneyBox moneyBox = vm.getMoneyBox();
        moneyBox.insert(x);
        System.out.println("현재 넣은 돈의 총합 : " + moneyBox.getMoney());
        if (drinking.getPrice() > moneyBox.getMoney()) {
            vm.setState(vm.getNoEnoughMoneyState());
        } else {
            vm.setState(vm.getEnoughMoneyState());
        }
    }

    @Override
    public void pushButton(VendingMachine vm) {
        System.out.println("금액이 0입니다.");
    }

    @Override
    public void returnCoin(VendingMachine vm) {
        System.out.println("반환할 금액이 없습니다.");
    }
}
