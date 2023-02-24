package sa.passenger;

public class BusPassenger extends Passenger{
    BusPassenger(int start) {
        this.start = start;
        // destination은 start보다 크고 route의 최대 스테이션보다는 작아야 함
        this.destination = start + 1 + (int) (Math.random() * (10 - start));
    }

}
