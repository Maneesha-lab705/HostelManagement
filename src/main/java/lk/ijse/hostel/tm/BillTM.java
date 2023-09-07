package lk.ijse.hostel.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BillTM {
    private String paymentId;
    private double keymony;
    private double amount;
    private double balance;
    private String resId;

}
