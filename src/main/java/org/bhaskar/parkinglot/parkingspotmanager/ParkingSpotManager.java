package org.bhaskar.parkinglot.parkingspotmanager;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bhaskar.parkinglot.Vehicle;
import org.bhaskar.parkinglot.parkingspot.ParkingSpot;
import org.bhaskar.parkinglot.strategy.ParkingStrategy;

import java.util.List;

@AllArgsConstructor
@Data
public abstract class ParkingSpotManager {
    List<? extends ParkingSpot> parkingSpotList;

    public abstract ParkingSpot findParkingSpot(ParkingStrategy parkingStrategy);

    public abstract void addParkingSpot(ParkingSpot parkingSpot);
    public abstract void removeParkingSpot(ParkingSpot parkingSpot);
    public abstract void parkVehicle(Vehicle vehicle);

    public abstract void removeVehicle(Vehicle vehicle);


}
