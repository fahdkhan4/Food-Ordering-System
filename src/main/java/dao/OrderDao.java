package dao;

import Model.Meal;
import Model.Order;
import configuration.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class OrderDao {

    private HibernateConfig hibernateConfig = new HibernateConfig();

    /**
     *
     * @param order
     * @return
     * @throws Exception
     */
    public Long saveOrder(Order order){
        Session session = null;
        Long orderId = null;
        try{
            SessionFactory sessionFactory = hibernateConfig.hibernateConfiguration();
            session  = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            orderId = (Long) session.save(order);

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return orderId;
    }


    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Order getOrderById(Long id){
        Session session = null;
        Transaction tx = null;
        Order order = null;
        try{
            SessionFactory sessionFactory = hibernateConfig.hibernateConfiguration();
            session  = sessionFactory.openSession();
            tx= session.beginTransaction();

            order = session.get(Order.class,id);

            tx.commit();


        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();

        }
        return order;
    }
}
