package sa;

import sa.passenger.Passenger;

import java.util.List;

public class Taxi extends Transport {
    int maxPassenger = 4;
    String destination;    // 목적지
    int distanceOfDestination;  // 목적지까지 거리
    int baseDistance = 100;   // 기본 거리
    int baseFare = 3000;   // 기본 요금
    int farePerDistance = 1000;    // 거리당 요금

    int oil = 100;
    int currentSpeed = 0;
    final int maxSpeed = 150;

    @Override
    void run() {

    }

    @Override
    void changeSpeed(int x) {

    }

    @Override
    void changeState(int x) {

    }

    @Override
    void getOff(int location) {

    }

    @Override
    void pickUp(List<Passenger> passengerList) {

    }
}
