package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.Dto.RoomDto;
import lk.ijse.hostel.bo.custom.RoomBO;
import lk.ijse.hostel.dao.custom.RoomDao;
import lk.ijse.hostel.dao.custom.impl.RoomDaoImpl;
import lk.ijse.hostel.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBO {
    RoomDao roomDao =new RoomDaoImpl();
    @Override
    public boolean save(RoomDto roomDto) {
        return roomDao.save(new Room(roomDto.getRoom_id(),roomDto.getRoom_Type_id(),roomDto.getType(),roomDto.getKeymoney(),roomDto.getQty()));
    }

    @Override
    public boolean delete(RoomDto roomDto) {
        return roomDao.delete(new Room(roomDto.getRoom_id()));
    }

    @Override
    public boolean update(RoomDto roomDto) {
        return roomDao.update(new Room(roomDto.getRoom_id(),roomDto.getRoom_Type_id(),roomDto.getType(),roomDto.getKeymoney(),roomDto.getQty()));

    }

    @Override
    public RoomDto serch(String roomId) {
        Room room= roomDao.serch(roomId);
        return new RoomDto(room.getRoom_id(),room.getRoom_Type_id(),room.getType(),room.getKeymoney(),room.getQty());
    }

    @Override
    public List<RoomDto> getAll() {
        List<RoomDto>roomDtoList = new ArrayList<>();
        List<Room>roomList = roomDao.getAll();
        for (Room room : roomList){
            roomDtoList.add(new RoomDto(room.getRoom_id(),room.getType(),room.getKeymoney(),room.getQty()));
        }
        return roomDtoList;
    }

    @Override
    public List<String> getRoomIds(String selectedItem) {
        return roomDao.getRoomIds(selectedItem);
    }

    @Override
    public List<String> getKeymoney(String selectedItem) {
        return roomDao.getKeyMony(selectedItem);
    }

    @Override
    public List<String> getQty(String selectedItem) {
        return roomDao.getQty(selectedItem);
    }

}
