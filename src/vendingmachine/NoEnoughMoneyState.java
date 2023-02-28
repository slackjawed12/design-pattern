package vendingmachine;

public class NoEnoughMoneyState implements State {

    @Override
    public void insertCoin(int x, VendingMachine vm) {
        Drinking drinking = vm.getDrinking();
        MoneyBox moneyBox = vm.getMoneyBox();
        moneyBox.insert(x);
        System.out.println("현재 넣은 돈의 총합 : " + moneyBox.getMoney());

        if (drinking.getPrice() <= moneyBox.getMoney()) {
            vm.setState(vm.getEnoughMoneyState());
        }
    }

    @Override
    public void pushButton(VendingMachine vm) {
        System.out.println("금액이 부족합니다.");
    }

    @Override
    public void returnCoin(VendingMachine vm) {
        MoneyBox moneyBox = vm.getMoneyBox();
        moneyBox.returnMoney();

        vm.setState(vm.getNoMoneyState());
    }
}
