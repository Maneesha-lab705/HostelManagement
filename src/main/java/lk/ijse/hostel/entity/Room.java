package lk.ijse.hostel.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lk.ijse.hostel.Dto.RoomDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {
    @Id
    private String room_id;
    private String room_Type_id;
    private String type;
    private String keymoney;
    private int qty;


    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<Reservation> resList =new ArrayList<>();

    public Room(String room_id, String room_Type_id, String type, String keymoney, int qty) {
        this.room_id = room_id;
        this.room_Type_id = room_Type_id;
        this.type = type;
        this.keymoney = keymoney;
        this.qty = qty;
    }

    public Room(String roomId) {
        this.room_id = roomId;
    }

}
