package org.bhaskar.parkinglot.parkingspot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bhaskar.parkinglot.ParkingSpotStatus;
import org.bhaskar.parkinglot.VehicleType;

import java.math.BigInteger;

@AllArgsConstructor
@Data
public abstract class ParkingSpot {
    int parkingId;
    ParkingSpotStatus parkingSpotStatus;
    int price;
    VehicleType vehicleType;


    public abstract BigInteger price();
}
