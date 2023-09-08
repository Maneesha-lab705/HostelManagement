package lk.ijse.hostel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Bill {
    @Id
    private String paymentId;
    private double keymony;
    private double amount;
    private double balance;
//
//    @OneToOne
//    @JoinColumn(name = "res_id")
//    private Reservation reservation;

//    public Bill(String paymentId, double amount, double balance) {
//        this
//    }
    public Bill(String paymentId, double amount, double balance) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.balance = balance;
    }
}
