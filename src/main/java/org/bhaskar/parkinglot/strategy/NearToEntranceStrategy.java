package org.bhaskar.parkinglot.strategy;

import org.bhaskar.parkinglot.ParkingSpotStatus;
import org.bhaskar.parkinglot.VehicleType;
import org.bhaskar.parkinglot.parkingspot.ParkingSpot;

import java.util.Comparator;
import java.util.List;

public class NearToEntranceStrategy extends ParkingStrategy {

    @Override
    public ParkingSpot findSpot(List<? extends ParkingSpot> parkingSpotList, VehicleType vehicleType) {
        return parkingSpotList.stream()
                .filter(parkingSpot -> parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE))
                .filter(parkingSpot -> parkingSpot.getVehicleType().equals(vehicleType))
                .min(Comparator.comparing(ParkingSpot::getParkingId))
                .orElse(null);
    }
}
