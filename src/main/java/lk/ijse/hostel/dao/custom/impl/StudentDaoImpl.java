package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.Dto.StudentDTO;
import lk.ijse.hostel.dao.custom.StudentDao;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public boolean save(Student student) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.persist(student);
        transaction.commit();
        session.close();
        return true;
    }



    @Override
    public boolean delete(Student student) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.remove(student);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public String getName(String sid) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("select name from Student where id=?1");
        query.setParameter(1,sid);
        String students = String.valueOf(query.uniqueResult());
        System.out.println(students);
        transaction.commit();
        session.close();

        return students;
    }

    @Override
    public List<Student> getStudents() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("from Student ");
        List <Student> studentList = query.list();
        transaction.commit();
        session.close();

        return studentList;
    }

    @Override
    public boolean update(Student student) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();

        return true;
    }


}
