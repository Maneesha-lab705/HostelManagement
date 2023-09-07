package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.entity.Room;

import java.util.List;

public interface RoomDao {

    boolean save(Room room);

    boolean delete(Room room);

    boolean update(Room room);

    Room serch(String roomId);

    List<Room> getAll();

    List<String> getRoomIds(String selectedItem);

    List<String> getKeyMony(String selectedItem);

    List<String> getQty(String selectedItem);

    List<Room> getAvaleble();



//
//    List<Room> getRoomIds();
}
