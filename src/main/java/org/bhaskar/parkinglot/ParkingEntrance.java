package org.bhaskar.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bhaskar.parkinglot.parkingspot.ParkingSpot;
import org.bhaskar.parkinglot.parkingspotmanager.FourWheelerParkingManager;
import org.bhaskar.parkinglot.parkingspotmanager.ParkingSpotManager;
import org.bhaskar.parkinglot.parkingspotmanager.TwoWheelerParkingManager;
import org.bhaskar.parkinglot.strategy.ParkingStrategy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Builder
@Data
public class ParkingEntrance {
    int id;
    List<ParkingSpot> parkingSpotList;
    ParkingSpotManager parkingSpotManager;
    Vehicle vehicle;
    ParkingStrategy parkingStrategy;
    private static final AtomicInteger ticketCounter = new AtomicInteger();

    ParkingEntrance(Vehicle vehicle, List<? extends ParkingSpot> parkingSpotList, ParkingStrategy parkingStrategy) {
        this.vehicle = vehicle;
        parkingSpotManager = parkingManagerAdaptor(vehicle, parkingSpotList);
        this.parkingStrategy = parkingStrategy;
    }

    private ParkingSpotManager parkingManagerAdaptor(Vehicle vehicle, List<? extends ParkingSpot> parkingSpotList) {
        if (vehicle.getVehicleType().equals(VehicleType.TWO_WHEELER))
            return new TwoWheelerParkingManager(parkingSpotList);
        else
            return new FourWheelerParkingManager(parkingSpotList);
    }


    public ParkingSpot findParkingSpot() {
        return parkingSpotManager.findParkingSpot(parkingStrategy);
    }

    public Ticket generateTicket(ParkingSpot parkingSpot) {
        return new Ticket(ticketCounter.incrementAndGet(), LocalDateTime.now(), vehicle, parkingSpot);
    }

}
