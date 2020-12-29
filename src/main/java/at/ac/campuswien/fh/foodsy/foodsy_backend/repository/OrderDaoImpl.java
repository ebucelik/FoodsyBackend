package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Ordering;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    static Session session;
    private static final String READ_ALL_ORDERS_BY_UUID = "Select o FROM Ordering o WHERE o.orderingUuid = ?0";
    private static final String READ_ORDER_BY_ID = "Select o FROM Ordering o WHERE o.id = ?0";

    @Override
    public List<Ordering> getAllOrdersByUuid(String uuid) {
        try{
            session = sessionFactory.openSession();
            Query<Ordering> getAllOrdersByUuid = session.createQuery(READ_ALL_ORDERS_BY_UUID);
            getAllOrdersByUuid.setParameter(0, uuid);

            return getAllOrdersByUuid.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    private Ordering getOrderById(long id){
        try{
            session = sessionFactory.openSession();
            Query<Ordering> getOrderById = session.createQuery(READ_ORDER_BY_ID);
            getOrderById.setParameter(0, id);

            return getOrderById.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Ordering save(Ordering ordering) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            long savedId = (long) session.save(ordering);
            session.getTransaction().commit();

            return getOrderById(savedId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Ordering delete(Ordering ordering) {
        Ordering orderingDeleted = ordering;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(ordering);
            session.getTransaction().commit();

            return orderingDeleted;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
