package org.bhaskar.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@AllArgsConstructor
@Builder
@Data
public class ParkingExit {
    int exitGateNumber;

    public BigDecimal calculateCost(){
        return null;
    }
    public void updateParkingSpot(){

    }

}
