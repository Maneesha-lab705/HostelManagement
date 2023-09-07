package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.Dto.RoomDto;
import lk.ijse.hostel.Dto.StudentDTO;
import lk.ijse.hostel.bo.custom.StudentManageBO;
import lk.ijse.hostel.dao.custom.StudentDao;
import lk.ijse.hostel.dao.custom.impl.StudentDaoImpl;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManageBOImpl implements StudentManageBO {
    StudentDao studentDao =new StudentDaoImpl();

    @Override
    public List<StudentDTO> getAllStudent() {
        List<StudentDTO> studentDTOS=new ArrayList<>();
        List<Student> studentList=studentDao.getStudents();

        for (Student student :studentList){
            studentDTOS.add(new StudentDTO(student.getStudentId(),student.getName(),student.getAddress(),student.getContact(),student.getDob(),student.getGender()));
        }
        return studentDTOS;
    }

    @Override
    public boolean update(StudentDTO studentDTO) {
        return studentDao.update(new Student(studentDTO.getStudentId(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getContact(),studentDTO.getDob(),studentDTO.getGender()));

    }

    @Override
    public boolean delete(StudentDTO studentDTO) {
        return studentDao.delete(new Student(studentDTO.getStudentId()));
    }

}
