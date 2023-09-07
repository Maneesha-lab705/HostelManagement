package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.entity.Bill;

import java.util.List;

public interface BillDAO {

    boolean save(Bill bill);

    String genarateBill();

    List<Bill> getAllPayment();

    String getStudentId(String resId);

    boolean update(Bill bill);
}
