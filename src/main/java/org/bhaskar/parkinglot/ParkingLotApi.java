package org.bhaskar.parkinglot;

import org.bhaskar.parkinglot.parkingspot.FourWheelerSpot;
import org.bhaskar.parkinglot.parkingspot.ParkingSpot;
import org.bhaskar.parkinglot.parkingspot.TwoWheelerSpot;
import org.bhaskar.parkinglot.strategy.NearToEntranceStrategy;
import org.bhaskar.parkinglot.strategy.NearToExitStrategy;
import org.bhaskar.parkinglot.strategy.ParkingStrategy;

import java.util.Arrays;
import java.util.List;

public class ParkingLotApi {
    public static void main(String[] args) {
        Vehicle vehicle1 = Vehicle.builder()
                .vehicleId(1105)
                .vehicleType(VehicleType.TWO_WHEELER)
                .build();
        Vehicle vehicle2 = Vehicle.builder()
                .vehicleId(2610)
                .vehicleType(VehicleType.FOUR_WHEELER)
                .build();

        List<ParkingSpot> twoWheelerParkingSpotList = Arrays.asList(
                new TwoWheelerSpot(1, ParkingSpotStatus.AVAILABLE, 10, VehicleType.TWO_WHEELER),
                new TwoWheelerSpot(2, ParkingSpotStatus.AVAILABLE, 10, VehicleType.TWO_WHEELER),
                new TwoWheelerSpot(3, ParkingSpotStatus.AVAILABLE, 10, VehicleType.TWO_WHEELER)
        );
        List<ParkingSpot> fourWheelerParkingSpotList = Arrays.asList(
                new FourWheelerSpot(4, ParkingSpotStatus.OCCUPIED, 20, VehicleType.FOUR_WHEELER),
                new FourWheelerSpot(5, ParkingSpotStatus.AVAILABLE, 20, VehicleType.FOUR_WHEELER),
                new FourWheelerSpot(6, ParkingSpotStatus.AVAILABLE, 20, VehicleType.FOUR_WHEELER),
                new FourWheelerSpot(7, ParkingSpotStatus.AVAILABLE, 20, VehicleType.FOUR_WHEELER)
        );

        ParkingStrategy nearToEntranceStrategy =new NearToEntranceStrategy();
        ParkingStrategy nearToExitStrategy =new NearToExitStrategy();
        ParkingEntrance parkingEntrance =new ParkingEntrance(vehicle2, fourWheelerParkingSpotList,nearToExitStrategy);
        ParkingSpot parkingSpot=parkingEntrance.findParkingSpot();
        System.out.println(parkingSpot);
        Ticket ticket = parkingEntrance.generateTicket(parkingSpot);

        System.out.println(ticket);

    }
}
