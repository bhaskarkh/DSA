package org.bhaskar.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Vehicle {
    int vehicleId;
    VehicleType vehicleType;
}
