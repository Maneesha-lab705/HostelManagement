package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.LoginBO;
import lk.ijse.hostel.dao.custom.UserDAO;
import lk.ijse.hostel.dao.custom.impl.UserDAOImpl;

public class LogingBOImpl implements LoginBO {
    UserDAO userDAO =new UserDAOImpl();
    @Override
    public boolean serch(String userName, String password) {
        return userDAO.serch(userName,password);
    }
}
