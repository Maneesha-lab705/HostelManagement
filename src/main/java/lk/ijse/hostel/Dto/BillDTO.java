package lk.ijse.hostel.Dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lk.ijse.hostel.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillDTO {
    private String paymentId;
    private double keymony;
    private double amount;
    private double balance;
    private ReservationDTO reservation;

    public BillDTO(String payId, double newPayment, double newBalance) {
        this.paymentId=payId;
        this.amount=newPayment;
        this.balance=newBalance;

    }
}
