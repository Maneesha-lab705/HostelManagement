package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.ReservationDao;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

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
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT r.res_id FROM Reservation r ORDER BY r.res_id DESC LIMIT  1");
        String currentId = String.valueOf(query.uniqueResult());
        transaction.commit();

        return nextId(currentId);
    }
    private String nextId(String currentId) {
        if (currentId != null){
            String[] strings = currentId.split("R0");
            int Nid = Integer.parseInt(strings[1]);
            Nid++;

            return "R00"+Nid;
        }
        return "R001";
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
    public String getRoomId(String paymentId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery nativeQuery = session.createNativeQuery("SELECT room_id FROM reservation WHERE student_id = ?1");
        nativeQuery.setParameter(1, paymentId);
        String roomId = (String) (nativeQuery.uniqueResult());
        transaction.commit();

        return roomId;
    }



}
