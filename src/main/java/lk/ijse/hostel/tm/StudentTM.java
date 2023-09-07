package lk.ijse.hostel.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentTM {
    private String StudentId;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;

}
