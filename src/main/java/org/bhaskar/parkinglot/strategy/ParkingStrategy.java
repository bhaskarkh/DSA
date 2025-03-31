package org.bhaskar.parkinglot.strategy;

import org.bhaskar.parkinglot.ParkingSpotStatus;
import org.bhaskar.parkinglot.VehicleType;
import org.bhaskar.parkinglot.parkingspot.ParkingSpot;

import java.util.List;

public  abstract class ParkingStrategy {
    public abstract ParkingSpot findSpot(List<? extends ParkingSpot> parkingSpotList, VehicleType vehicleType);
}
