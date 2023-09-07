package lk.ijse.hostel.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Student {
    @Id
    private String StudentId;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Reservation> resList =new ArrayList<>();


    public Student(String studentId, String name, String address, String contact, LocalDate dob, String gender) {
        StudentId = studentId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
    }

    public Student(String studentId) {
        this.StudentId=studentId;
    }
}