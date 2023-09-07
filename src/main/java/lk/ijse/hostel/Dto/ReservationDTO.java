package lk.ijse.hostel.Dto;

import lk.ijse.hostel.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReservationDTO {
    private String res_id;
    private LocalDate date;
    private LocalDate duedata;
    private String room_type_id;

    private RoomDto room;
    private StudentDTO student;

    public ReservationDTO(String res_id) {
        this.res_id=res_id;
    }


//
//    public ReservationDTO(String res_id, LocalDate date, LocalDate duedata, String room, Student student) {
//        this.res_id=res_id;
//        this.date=date;
//        this.duedata=duedata;
//        this.room_type_id=room;
//        this.student=student;
//
//    }
//

//    public ReservationDTO(String resId, LocalDate date, LocalDate endDate, String roomType, RoomDto roomDto, StudentDTO studentDTO) {
//        this.res_id=res_id;
//        this.date=date;
//        this.duedata=duedata;
//        this.room_type_id=roomType;
//        this.student=student;
//    }
//
//    public ReservationDTO(String res_id, LocalDate date, LocalDate duedata, String room_type_id, Student student) {
//        this.res_id=res_id;
//        this.date=date;
//        this.duedata=duedata;
//        this.room_type_id=room_type_id;
//        this.student=student;
//    }
}
