package lk.ijse.hostel.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReservationTM {
    private String res_id;
    private LocalDate date;
    private LocalDate duedata;
    private String room_type_id;
    private String sId;

}
