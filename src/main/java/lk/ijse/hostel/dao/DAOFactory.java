package lk.ijse.hostel.dao;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
    ROOM ,RESERVATION ,STUDENT
    }

//
//    public SuperDAO getDAO(DAOTypes types){
//        switch (types) {
//            case ROOM:
//                return new ();
//            case ITEM:
//                return new ItemDAOImpl();
//            case ORDERS:
//                return new OrdersDAOImpl();
//            default:
//                return null;
//        }
//    }
}
