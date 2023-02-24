package sa;

import sa.passenger.Passenger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bus extends Transport {
    int maxPassenger = 30; // 최대 승객수
    int currentPassenger; // 현재 승객수
    List<Passenger> passengerList = new ArrayList<>();
    int fare = 1000;   // 요금
    int revenue = 0;
    static int busId = 0;   // 버스 아이디 - 객체 생성마다 +1
    int number; // 버스 번호
    int oil = 100;    // 주유량
    int currentSpeed;   // 현재 속도
    final int maxSpeed = 100; // 최대 속도
    int distance; // 움직인 거리

    BusState state = BusState.RUNNING;  // 버스 상태

    Bus() {
        this.number = ++busId;
        System.out.println(this.number + "번 버스객체 만들어짐!");
    }

    void run() {    // 운행
        if (oil < 5) {
            System.out.println("더 운행할 수 없어 차고지로 직행합니다.");
            setState(BusState.TO_GARAGE);
        } else if (oil < 10) {
            System.out.println("주유가 필요합니다.");
        } else {
            oil -= 5;
            distance += currentSpeed;
            System.out.print("현재 속도 = " + currentSpeed + ", ");
            System.out.println("다음 정류장까지 남은 거리 = " + (100 - distance));
        }
    }

    void stopAtStation(Route route) {   // 정류장 도착하면 하차
        if (currentSpeed == 0) {
            boolean isStation = distance != 0 && distance % route.distanceBetweenStation == 0;
            if (isStation) {    // 정류장이고
                if (state == BusState.RUNNING) {    // 운행 중이면
                    int location = distance / route.distanceBetweenStation - 1; // 인덱스 계산
                    getOff(location);   // 목적지 승객 내림
                    pickUp(route.passengerInfo.get(location));  // 출발지 승객 탑승
                } else {
                    System.out.println("차고지행 버스입니다. 승객을 태울 수 없습니다.");
                }
            } else {    // 정류장 아님
                System.out.println("정류장이 아닙니다");
            }
        } else {
            System.out.println("정차하려면 속도를 줄이십시오");
        }
    }

    void setState(BusState state) { // 버스 상태 변경
        this.state = state;
    }

    void getOff(int location) { // 승객 목적지가 현재 위치와 같으면 하차
        for (Iterator<Passenger> it = passengerList.iterator(); it.hasNext(); ) {
            Passenger p = it.next();
            if (p.getDestination() == location) {
                it.remove();
                currentPassenger--;
            }
        }
    }

    void pickUp(List<Passenger> passengers) { // 승객 탑승
        if (currentPassenger + passengers.size() < maxPassenger) {
            currentPassenger += passengers.size();
            passengers.forEach(x -> {
                passengerList.add(x);
                revenue += fare;
            });
            System.out.println("탑승 승객 수 = " + currentPassenger);
        } else {
            System.out.println("최대 승객 수를 초과했습니다.");
        }
    }

    void changeSpeed(int x) { // 속도 변경
        if (currentSpeed + x > maxSpeed) {
            currentSpeed = maxSpeed;
        } else if (currentSpeed + x > 0) {
            currentSpeed += x;
        } else {
            currentSpeed = 0;
        }
    }

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public int getCurrentPassenger() {
        return currentPassenger;
    }

    public int getRemain() {
        return maxPassenger - currentPassenger;
    }

    public int getFare() {
        return fare;
    }

    public static int getBusId() {
        return busId;
    }

    public int getNumber() {
        return number;
    }

    public int getOil() {
        return oil;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public BusState getState() {
        return state;
    }

    public void changeState(int s) {
        switch (s) {
            case 1:
                setState(BusState.RUNNING);
                break;
            case 2:
                setState(BusState.TO_GARAGE);
                break;
        }
    }

    public void printInfo() {
        System.out.print("탑승 승객 수 = " + currentPassenger + ", ");
        System.out.println("잔여 승객 수 = " + (maxPassenger - currentPassenger));

        System.out.println("현재 속도 = " + currentSpeed);
        System.out.print("요금 확인 = " + fare + ", ");
        System.out.print("상태 = " + (state == BusState.TO_GARAGE ? "차고지행" : "운행중") + ", ");
        System.out.println("주유량 = " + oil);
    }
}
