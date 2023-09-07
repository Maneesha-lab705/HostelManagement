package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.Dto.RoomDto;
import lk.ijse.hostel.Dto.StudentDTO;

import java.util.List;

public interface StudentManageBO {


    List<StudentDTO> getAllStudent();

    boolean update(StudentDTO studentDTO);

    boolean delete(StudentDTO studentDTO);
}
