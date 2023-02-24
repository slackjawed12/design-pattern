package sa;

import sa.passenger.Passenger;

import java.util.List;

public abstract class Transport {
    int num;
    int oil;
    int maxPassenger; // 최대 승객수
    int currentPassenger; // 현재 승객수
    int fare;   // 요금
    int currentSpeed;   // 현재 속도
    int maxSpeed = 100; // 최대 속도
    int distance; // 움직인 거리

    abstract void run();

    abstract void changeSpeed(int x);

    abstract void changeState(int x);

    abstract void getOff(int location);

    abstract void pickUp(List<Passenger> passengerList);

}
