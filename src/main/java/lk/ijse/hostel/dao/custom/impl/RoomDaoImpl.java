package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.RoomDao;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RoomDaoImpl implements RoomDao {

    @Override
    public boolean save(Room room) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.persist(room);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(Room room) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Room room1 = session.get(Room.class,room.getRoom_id());
        session.remove(room1);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Room room) {
            Session session= FactoryConfiguration.getInstance().getSession();
            Transaction transaction=session.beginTransaction();
            session.update(room);
            transaction.commit();
            session.close();

            return  true;

    }

    @Override
    public Room serch(String roomId) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Room room = session.get(Room.class,roomId);
        transaction.commit();
        session.close();

        return room;
    }

    @Override
    public List<Room> getAll() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("from Room ");
        List <Room> roomList = query.list();
        transaction.commit();
        session.close();

        return roomList;
    }

    @Override
    public List<String> getRoomIds(String selectedItem) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT room_id FROM Room  WHERE room_Type_id=?1");
        query.setParameter(1,selectedItem);
        List<String> roomIds = query.list();
        transaction.commit();
        return roomIds;
    }

    @Override
    public List<String> getKeyMony(String selectedItem) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT keymoney FROM Room  WHERE room_Type_id=?1");
        query.setParameter(1,selectedItem);
        List<String> roomIds = query.list();
        transaction.commit();
        return roomIds;
    }

    @Override
    public List<String> getQty(String selectedItem) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT qty FROM Room  WHERE room_Type_id=?1");
        query.setParameter(1,selectedItem);
        List<String> roomIds = query.list();
        transaction.commit();
        return roomIds;

    }

    @Override
    public List<Room> getAvaleble() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("from Room ");
        List <Room> roomList = query.list();
        transaction.commit();
        session.close();

        return roomList;
    }


//    @Override
//    public List<Room> getRoomIds() {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        Query query = session.createQuery("SELECT r.room_id FROM Room r WHERE r.room_Type_id=?");
//        List<Room> roomIds = query.list();
//        transaction.commit();
//        return roomIds;
//    }
}
