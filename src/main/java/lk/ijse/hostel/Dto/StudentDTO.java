package lk.ijse.hostel.Dto;

import lk.ijse.hostel.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class StudentDTO {
    private String StudentId;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;

    private List<ReservationDTO> resList;

    public StudentDTO(String sId, String name, String address, String contact, LocalDate dob, String gender) {
        this. StudentId = sId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;

    }

    public StudentDTO() {

    }

    public StudentDTO(String studentId) {
        this.StudentId = studentId;
    }

//    public StudentDTO(String studentId, String name, String address, String contact, LocalDate dob, String gender) {
//       this. StudentId = studentId;
//        this.name = name;
//        this.address = address;
//        this.contact = contact;
//        this.dob = dob;
//        this.gender = gender;
//    }
//
//
//    public StudentDTO(String id) {
//        this.StudentId=id;
//    }
}
