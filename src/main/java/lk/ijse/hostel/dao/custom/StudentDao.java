package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.Dto.StudentDTO;
import lk.ijse.hostel.entity.Student;

import java.util.List;

public interface StudentDao {
    boolean save(Student student);

    boolean delete(Student student);

    String getName(String sid);

    List<Student> getStudents();

    boolean update(Student student);
}
