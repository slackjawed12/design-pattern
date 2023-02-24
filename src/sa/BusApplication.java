package sa;

import sa.passenger.Passenger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class BusApplication {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();
        Route route = new Route(100, 10);
        for (List<Passenger> passengerList : route.passengerInfo) {
            for (Passenger p : passengerList) {
                System.out.print("(" + p.getStart() + ", " + p.getDestination() + ") ");
            }
            System.out.println();
        }
        while (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("| 1. 운행 | 2. 정차 | 3. 속도변경 | 4. 상태변경 | 5. 정보확인 | 6. 종료 |");
            System.out.println("------------------------------------------------------------------");
            System.out.print("옵션 선택 > ");
            int option = Integer.parseInt(rd.readLine());
            switch (option) {
                case 1:
                    bus1.run();
                    break;
                case 2:
                    bus1.stopAtStation(route);
                    break;
                case 3:
                    System.out.print("가속/감속할 속도 = ");
                    int addSpeed = Integer.parseInt(rd.readLine());
                    bus1.changeSpeed(addSpeed);
                    break;
                case 4:
                    System.out.print("어떤 상태로 변경하시겠습니까? 1. 운행 2. 차고지행 > ");
                    int s = Integer.parseInt(rd.readLine());
                    bus1.changeState(s);
                    break;
                case 5:
                    bus1.printInfo();
                    break;
                case 6:
                    break;
                default:
                    break;
            }
            if (option == 6) break;
        }
    }
}
