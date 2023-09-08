package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.UserDAO;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.entity.User;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User user) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean serch(String userName, String password) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery(" FROM User WHERE userName = ?1 AND password= ?2");
        query.setParameter(1,userName);
        query.setParameter(2,password);
        Object o = query.uniqueResult();
        transaction.commit();
        session.close();

        if (o !=null){
            return true;
        }else return false;
    }
}
