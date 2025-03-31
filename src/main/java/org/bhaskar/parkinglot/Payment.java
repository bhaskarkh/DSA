package org.bhaskar.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Payment {
    int paymentId;
    PaymentType paymentType;
    PaymentStatus paymentStatus;

    public void processPayment(){

    }
    public void updateStatus(){

    }

}
