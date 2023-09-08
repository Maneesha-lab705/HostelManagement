package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.Dto.ReservationDTO;
import lk.ijse.hostel.entity.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDao {
    String getResId();

    boolean save(Reservation reservation);

    List<Reservation> getAll();

    String getRoomId(String paymentId);


}
