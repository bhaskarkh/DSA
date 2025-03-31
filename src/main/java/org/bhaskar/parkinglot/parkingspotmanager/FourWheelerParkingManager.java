package org.bhaskar.parkinglot.parkingspotmanager;

import org.bhaskar.parkinglot.Vehicle;
import org.bhaskar.parkinglot.VehicleType;
import org.bhaskar.parkinglot.parkingspot.FourWheelerSpot;
import org.bhaskar.parkinglot.parkingspot.ParkingSpot;
import org.bhaskar.parkinglot.parkingspot.TwoWheelerSpot;
import org.bhaskar.parkinglot.strategy.ParkingStrategy;

import java.util.List;

public class FourWheelerParkingManager extends ParkingSpotManager{
    List<FourWheelerSpot> fourWheelerSpotList;
    public FourWheelerParkingManager(List<? extends ParkingSpot> fourWheelerSpotList) {
        super(fourWheelerSpotList);
        this.fourWheelerSpotList = (List<FourWheelerSpot>) fourWheelerSpotList;
    }

    @Override
    public ParkingSpot findParkingSpot(ParkingStrategy parkingStrategy) {
        return parkingStrategy.findSpot(fourWheelerSpotList, VehicleType.FOUR_WHEELER);
    }

    @Override
    public void addParkingSpot(ParkingSpot parkingSpot) {

    }

    @Override
    public void removeParkingSpot(ParkingSpot parkingSpot) {

    }

    @Override
    public void parkVehicle(Vehicle vehicle) {

    }

    @Override
    public void removeVehicle(Vehicle vehicle) {

    }
}
