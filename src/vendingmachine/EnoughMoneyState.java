package vendingmachine;

public class EnoughMoneyState implements State {

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
        Drinking drinking = vm.getDrinking();
        MoneyBox moneyBox = vm.getMoneyBox();
        drinking.dispense();
        moneyBox.dispense(drinking.getPrice());
        if (drinking.getStock() == 0) {
            vm.setState(vm.getSoldOutState());
        } else if(drinking.getPrice() > moneyBox.getMoney()){
            vm.setState(vm.getNoEnoughMoneyState());
        } else if(moneyBox.getMoney() == 0){
            vm.setState(vm.getNoMoneyState());
        }
    }

    @Override
    public void returnCoin(VendingMachine vm) {
        MoneyBox moneyBox = vm.getMoneyBox();
        moneyBox.returnMoney();

        vm.setState(vm.getNoMoneyState());
    }
}
