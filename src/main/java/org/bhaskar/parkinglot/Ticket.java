package org.bhaskar.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bhaskar.parkinglot.parkingspot.ParkingSpot;

import java.time.LocalDateTime;
@AllArgsConstructor
@Builder
@Data
public class Ticket {
    int ticketId;
    LocalDateTime entryTime;
    Vehicle vehicle;
    ParkingSpot parkingSpot;

}
