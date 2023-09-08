package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.Dto.BillDTO;
import lk.ijse.hostel.bo.custom.KeyMoneyBO;
import lk.ijse.hostel.dao.custom.BillDAO;
import lk.ijse.hostel.dao.custom.ReservationDao;
import lk.ijse.hostel.dao.custom.impl.BillDAOImpl;
import lk.ijse.hostel.dao.custom.impl.ReservationDaoImpl;
import lk.ijse.hostel.entity.Bill;

import java.util.ArrayList;
import java.util.List;

public class KeyMoneyBOImpl implements KeyMoneyBO {
    ReservationDao reservationDao =new ReservationDaoImpl();
    BillDAO billDAO =new BillDAOImpl();
    @Override
    public List<BillDTO> getAllPayment() {
        List<BillDTO> billDTOS = new ArrayList<>();
        List<Bill>bills = billDAO.getAllPayment();
        for (Bill bill : bills){
            billDTOS.add(new BillDTO(bill.getPaymentId(),bill.getKeymony(),bill.getAmount(),bill.getBalance()));
        }
        return billDTOS;
    }

    @Override
    public String getStudentId(String resId) {
        return billDAO.getStudentId(resId);
    }

    @Override
    public String getRoomId(String paymentId) {
        return reservationDao.getRoomId(paymentId);
    }

    @Override
    public boolean payed(BillDTO billDTO) {
        return billDAO.update(new Bill(billDTO.getPaymentId(),billDTO.getAmount(),billDTO.getBalance()));
    }
}
