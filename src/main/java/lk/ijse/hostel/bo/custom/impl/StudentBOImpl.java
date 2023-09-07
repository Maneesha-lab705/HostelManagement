package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.StudendBO;
import lk.ijse.hostel.dao.custom.StudentDao;
import lk.ijse.hostel.dao.custom.impl.StudentDaoImpl;

public class StudentBOImpl implements StudendBO {
    StudentDao studentDao =new StudentDaoImpl();
//    @Override
//    public String getresId() {
////        return studentDao.getResId();
//        return  null;
//    }
}
