package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.Dto.BillDTO;
import lk.ijse.hostel.Dto.ReservationDTO;
import lk.ijse.hostel.Dto.RoomDto;
import lk.ijse.hostel.Dto.StudentDTO;

import java.util.List;

public interface ReservationBO {
//    String getresId();
//
//    boolean save(ReservationDTO reservationDTO, StudentDTO studentDTO, BillDTO billDTO);
//
    String genarateenxtBillId();

    boolean save(ReservationDTO reservationDTO, RoomDto roomDto, StudentDTO studentDTO, BillDTO billDTO);

    List<ReservationDTO> getAll();

    List<RoomDto> getAllAvaleble();

    String getName(String sid);

    boolean delete(StudentDTO studentDTO);

    String getRoomId(String res_id);

    boolean delete(String id);

    String getResId();



//
//
//    boolean delete(StudentDTO studentDTO);
//
//    List<ReservationDTO> getAll();
}
