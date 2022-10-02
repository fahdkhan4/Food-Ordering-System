package dao;

import Model.Cuisine;
import Model.Meal;
import configuration.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CuisineDao {
    private HibernateConfig hibernateConfig = new HibernateConfig();

    /**
     *
     * @param cuisine
     * @throws Exception
     */
    public void saveCuisineDao(Cuisine cuisine){
        Session session  = null;
        Transaction tx = null;
        try{
            SessionFactory sessionFactory = hibernateConfig.hibernateConfiguration();
            session  = sessionFactory.openSession();
            tx= session.beginTransaction();

            session.save(cuisine);

            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();

        }
    }

    /**
     *
     * @param id
     * @return Cuisine
     * @throws Exception
     */
    public Cuisine getCuisineById(Long id) {
        Session session  = null;
        Transaction tx = null;
        Cuisine cuisine = null;
        try{
            SessionFactory sessionFactory = hibernateConfig.hibernateConfiguration();
            session  = sessionFactory.openSession();
            tx= session.beginTransaction();

            cuisine = session.get(Cuisine.class,id);

            tx.commit();


        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return cuisine;
    }

    /**
     *
     * @return List<Cuisine>
     * @throws Exception
     */
    public List<Cuisine> getCuisine() {
        Session session = null;
        List<Cuisine> cuisines = new ArrayList<>();
        try{
            SessionFactory sessionFactory = hibernateConfig.hibernateConfiguration();
            session  = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Cuisine");
            cuisines  = query.list();

            tx.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return cuisines;
    }

}
