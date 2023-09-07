package lk.ijse.hostel.Dto;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDto {

    private String room_id;
    private String room_Type_id;
    private String type;
    private String keymoney;
    private int qty;

    private List<ReservationDTO> resList =new ArrayList<>();

    public RoomDto(String roomid) {
        this.room_id=roomid;
    }


    public RoomDto(String room_id, String type, String keymoney, int qty) {
        this.room_id = room_id;
        this.type = type;
        this.keymoney = keymoney;
        this.qty = qty;
    }



    public RoomDto(String room_id, String room_Type_id, String type, String keymoney, int qty) {
        this.room_id = room_id;
        this.room_Type_id = room_Type_id;
        this.type = type;
        this.keymoney = keymoney;
        this.qty = qty;
    }

    public RoomDto(String room_id, String keymoney, int qty, String room_type_id) {
        this.room_id =room_id;
        this.keymoney=keymoney;
        this.qty=qty;
        this.room_Type_id=room_type_id;
    }
}
