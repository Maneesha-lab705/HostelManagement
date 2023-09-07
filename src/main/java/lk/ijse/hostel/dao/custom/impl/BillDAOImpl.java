package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.BillDAO;
import lk.ijse.hostel.entity.Bill;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class BillDAOImpl implements BillDAO {
    @Override
    public boolean save(Bill bill) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.persist(bill);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public String genarateBill() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT b.paymentId FROM Bill b ORDER BY b.paymentId DESC LIMIT  1");
        String currentId = String.valueOf(query.uniqueResult());
        transaction.commit();

        return nextId(currentId);
    }

    @Override
    public List<Bill> getAllPayment() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("from Bill ");
        List <Bill> billList = query.list();
        transaction.commit();
        session.close();

        return billList;
    }

    @Override
    public String getStudentId(String resId) {
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            NativeQuery nativeQuery = session.createNativeQuery("SELECT student_id FROM reservation WHERE res_id = ?1");
            nativeQuery.setParameter(1, resId);
            String SId = (String) (nativeQuery.uniqueResult());
            transaction.commit();

            return SId;
    }

    @Override
    public boolean update(Bill bill) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query= session.createQuery("UPDATE Bill SET balance=?1,amount=?2 where paymentId=?3");
        query.setParameter(1,bill.getBalance());
        query.setParameter(2,bill.getAmount());
        query.setParameter(3,bill.getPaymentId());
        int execute = query.executeUpdate();
        transaction.commit();
        session.close();

        if (execute > 0){
            return true;
        }else {
            return false;
        }
    }

    private String nextId(String currentId) {
        if (currentId != null){
            String[] strings = currentId.split("P0");
            int Nid = Integer.parseInt(strings[1]);
            Nid++;

            return "P0"+Nid;
        }
        return "B001";
    }
}
