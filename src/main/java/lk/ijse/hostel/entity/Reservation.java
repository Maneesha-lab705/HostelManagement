package lk.ijse.hostel.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Reservation {
    @Id
    private String res_id;
    private LocalDate date;
    private LocalDate duedata;
    private String room_type_id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "student_id")
    private  Student student;

    public Reservation(String res_id) {
        this.res_id=res_id;
    }

    public Reservation(String res_id, LocalDate date, LocalDate duedata, String room_type_id, Room room, Student student) {
        this.res_id = res_id;
        this.date = date;
        this.duedata = duedata;
        this.room_type_id = room_type_id;
        this.room = room;
        this.student = student;
    }
}
