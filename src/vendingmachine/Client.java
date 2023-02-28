package vendingmachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        VendingMachine vendingMachine = new VendingMachine(1, 1000);
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("| 1. 금액 투입 | 2. 음료 선택 | 3. 금액 반환 | 4. 종료 |");
            System.out.println("--------------------------------------------------");
            int choice = Integer.parseInt(rd.readLine());
            switch (choice) {
                case 1:
                    System.out.print("투입 금액 입력 : ");
                    int moneyInput = Integer.parseInt(rd.readLine());
                    vendingMachine.insertMoney(moneyInput);
                    break;
                case 2:
                    vendingMachine.pushButton();
                    break;
                case 3:
                    vendingMachine.returnMoney();
                    break;
                case 4:
                    System.out.println("자판기 사용 종료");
                    return;
                default:
                    break;
            }
        }
    }
}
