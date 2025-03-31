package org.bhaskar.parkinglot.parkingspot;



import org.bhaskar.parkinglot.ParkingSpotStatus;
import org.bhaskar.parkinglot.VehicleType;

import java.math.BigInteger;

public class TwoWheelerSpot extends ParkingSpot{

    public TwoWheelerSpot(int parkingId, ParkingSpotStatus parkingSpotStatus, int price, VehicleType vehicleType) {
        super(parkingId, parkingSpotStatus, price, vehicleType);
    }


    @Override
    public BigInteger price() {
        return BigInteger.TWO;
    }
}
