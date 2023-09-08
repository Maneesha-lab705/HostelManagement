package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.Dto.UserDTO;
import lk.ijse.hostel.bo.custom.UserBO;
import lk.ijse.hostel.dao.custom.UserDAO;
import lk.ijse.hostel.dao.custom.impl.UserDAOImpl;
import lk.ijse.hostel.entity.User;

public class UserBOImpl implements UserBO {
    UserDAO userDAO =new UserDAOImpl();
    @Override
    public boolean save(UserDTO userDTO) {
        return userDAO.save(new User(userDTO.getUserName(),userDTO.getPassword()));
    }
}
