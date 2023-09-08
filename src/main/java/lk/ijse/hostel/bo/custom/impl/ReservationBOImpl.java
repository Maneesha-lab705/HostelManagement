package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.Dto.BillDTO;
import lk.ijse.hostel.Dto.ReservationDTO;
import lk.ijse.hostel.Dto.RoomDto;
import lk.ijse.hostel.Dto.StudentDTO;
import lk.ijse.hostel.bo.custom.ReservationBO;
import lk.ijse.hostel.dao.custom.BillDAO;
import lk.ijse.hostel.dao.custom.ReservationDao;
import lk.ijse.hostel.dao.custom.RoomDao;
import lk.ijse.hostel.dao.custom.StudentDao;
import lk.ijse.hostel.dao.custom.impl.BillDAOImpl;
import lk.ijse.hostel.dao.custom.impl.ReservationDaoImpl;
import lk.ijse.hostel.dao.custom.impl.RoomDaoImpl;
import lk.ijse.hostel.dao.custom.impl.StudentDaoImpl;
import lk.ijse.hostel.entity.Bill;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;

import java.util.ArrayList;
import java.util.List;


public class ReservationBOImpl implements ReservationBO {
    ReservationDao reservationDao =new ReservationDaoImpl();
    StudentDao  studentDao =new StudentDaoImpl();
    BillDAO billDAO =new BillDAOImpl();
    RoomDao roomDao =new RoomDaoImpl();
//    @Override
//    public String getresId() {
//        return reservationDao.getResId();
//    }
//
    @Override
    public String genarateenxtBillId() {
       return billDAO.genarateBill();
    }

    @Override
    public boolean save(ReservationDTO reservationDTO, RoomDto roomDto, StudentDTO studentDTO, BillDTO billDTO) {
        Room room = new Room(reservationDTO.getRoom().getRoom_id());
        Student student = new Student(studentDTO.getStudentId(), studentDTO.getName(), studentDTO.getAddress(), studentDTO.getContact(), studentDTO.getDob(), studentDTO.getGender());
       Reservation reservation = new Reservation(reservationDTO.getRes_id(),reservationDTO.getDate(),reservationDTO.getDuedata(),reservationDTO.getRoom_type_id(),room,student);
        boolean isSaveStudent=studentDao.save(student);
        if (isSaveStudent) {
            boolean isReserved =reservationDao.save(reservation);
            if (isReserved){
                boolean isPaid=billDAO.save(new Bill(billDTO.getPaymentId(),billDTO.getKeymony(),billDTO.getAmount(),billDTO.getBalance()));
                if (isPaid){
                    return true;
                }
            }
        }
        return  false;
    }

    @Override
    public List<ReservationDTO> getAll() {
        List<ReservationDTO>reservationDTOS = new ArrayList<>();
        List<Reservation>reservationList = reservationDao.getAll();
        for (Reservation reservation : reservationList){
            reservationDTOS.add(new ReservationDTO(reservation.getRes_id(),reservation.getDate(),reservation.getDuedata(),reservation.getRoom_type_id(),new RoomDto(),new StudentDTO(reservation.getStudent().getStudentId())));
        }
        return reservationDTOS;
    }

    @Override
    public List<RoomDto> getAllAvaleble() {
        List<RoomDto> roomDaos=new ArrayList<>();
        List<Room> roomList=roomDao.getAvaleble();

        for (Room room :roomList){
            roomDaos.add(new RoomDto(room.getRoom_id(),room.getKeymoney(),room.getQty(),room.getRoom_Type_id()));
        }
        return roomDaos;
    }

    @Override
    public String getName(String sid) {
        return studentDao.getName(sid);
    }

    @Override
    public boolean delete(StudentDTO studentDTO) {
        return studentDao.delete(new Student(studentDTO.getStudentId()));
    }

    @Override
    public String getRoomId(String res_id) {
        return reservationDao.getRoomId(res_id);
    }

    @Override
    public boolean delete(String id) {
        return roomDao.delete(new Room(id));
    }

    @Override
    public String getResId() {
        return reservationDao.getResId();
    }


}
