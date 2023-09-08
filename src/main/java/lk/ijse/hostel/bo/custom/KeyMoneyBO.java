package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.Dto.BillDTO;

import java.util.List;

public interface KeyMoneyBO {
    List<BillDTO> getAllPayment();

    String getStudentId(String resId);

    String getRoomId(String paymentId);

    boolean payed(BillDTO billDTO);
}
