package sa;

import sa.passenger.Passenger;

import java.util.ArrayList;
import java.util.List;

public class Route {
    final int station;
    final int distanceBetweenStation;
    List<List<Passenger>> passengerInfo;

    Route(int distanceBetweenStation, int station) {
        this.distanceBetweenStation = distanceBetweenStation;
        this.station = station;
        this.passengerInfo = new ArrayList<>();
        for (int i = 0; i < station; i++) {
            List<Passenger> passengers = new ArrayList<>();
            // 각 정류장 별 승객 수
            int[] nums = {2, 45, 5, 0, 1, 7, 9, 0, 10, 3};
            for (int j = 0; j < nums[i]; j++) passengers.add(new Passenger(i));

            passengerInfo.add(passengers);
        }
    }
}
