package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.Dto.RoomDto;
import lk.ijse.hostel.entity.Room;

import java.util.List;

public interface RoomBO {
    boolean save(RoomDto roomDto);

    boolean delete(RoomDto roomDto);

    boolean update(RoomDto roomDto);

    RoomDto serch(String roomId);

    List<RoomDto> getAll();


    List<String> getRoomIds(String selectedItem);

    List<String> getKeymoney(String selectedItem);

    List<String> getQty(String selectedItem);
}
