package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.Dto.ReservationDTO;
import lk.ijse.hostel.dao.custom.ReservationDao;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class ReservationDaoImpl implements ReservationDao {
    @Override
    public boolean save(Reservation reservation) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.persist(reservation);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public String getResId() {
//        Session session= FactoryConfiguration.getInstance().getSession();
//        Transaction transaction=session.beginTransaction();
//        Query query = session.createQuery("from Room ");
//        List<Room> roomList = query.list();
//        transaction.commit();
//        session.close();
//
//        return roomList;
        return null;
    }
//
//    @Override
//    public boolean save(Reservation reservation) {
//        Session session= FactoryConfiguration.getInstance().getSession();
//        Transaction transaction=session.beginTransaction();
//        session.persist(reservation);
//        transaction.commit();
//        session.close();
//
//        return true;
//    }

    @Override
    public List<Reservation> getAll() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("from Reservation ");
        List <Reservation> roomList = query.list();
        transaction.commit();
        session.close();

        return roomList;
    }

    @Override
    public String getRoomId(String resId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery nativeQuery = session.createNativeQuery("SELECT room_id FROM reservation WHERE res_id = ?1");
        nativeQuery.setParameter(1, resId);
        String roomId = (String) (nativeQuery.uniqueResult());
        transaction.commit();

        return roomId;
    }



}
