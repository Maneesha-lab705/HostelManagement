package lk.ijse.hostel.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomTM {

    private String room_id;
    private String type;
    private String keymoney;
    private int qty;

}
