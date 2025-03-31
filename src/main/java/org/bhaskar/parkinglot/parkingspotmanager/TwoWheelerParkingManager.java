package org.bhaskar.parkinglot.parkingspotmanager;

import org.bhaskar.parkinglot.Vehicle;
import org.bhaskar.parkinglot.VehicleType;
import org.bhaskar.parkinglot.parkingspot.FourWheelerSpot;
import org.bhaskar.parkinglot.parkingspot.ParkingSpot;
import org.bhaskar.parkinglot.parkingspot.TwoWheelerSpot;
import org.bhaskar.parkinglot.strategy.ParkingStrategy;

import java.util.List;

public class TwoWheelerParkingManager extends ParkingSpotManager{
    List<TwoWheelerSpot> twoWheelerSpotList;
    public TwoWheelerParkingManager(List<? extends ParkingSpot> twoWheelerSpotList) {
        super(twoWheelerSpotList);
        this.twoWheelerSpotList = (List<TwoWheelerSpot>) twoWheelerSpotList;
    }

    @Override
    public ParkingSpot findParkingSpot(ParkingStrategy parkingStrategy) {
        return parkingStrategy.findSpot(twoWheelerSpotList, VehicleType.TWO_WHEELER);
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
