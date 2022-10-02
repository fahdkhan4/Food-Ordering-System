package dao;

import Model.Cuisine;
import Model.Drink;
import Model.Meal;
import configuration.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DrinkDao {
    private HibernateConfig hibernateConfig = new HibernateConfig();

    /**
     *
     * @param drink
     * @throws Exception
     */
    public void savedrink(Drink drink) {
        Session session = null;

        try{
            SessionFactory sessionFactory = hibernateConfig.hibernateConfiguration();
            session  = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.save(drink);

            tx.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }

    }

    /**
     *
     * @return List<Drink>
     * @throws Exception
     */
    public List<Drink> getAllDrinksDao() {
        Session session =null;
        List<Drink> drinks = new ArrayList<>();
        try{
            SessionFactory sessionFactory = hibernateConfig.hibernateConfiguration();
            session  = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Drink");
            drinks  = query.list();

            tx.commit();
            return drinks;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return drinks;
    }

    /**
     *
     * @param foodItem
     * @return Drink
     * @throws Exception
     */
    public Drink getDrinkById(Long foodItem){

        Session session  = null;
        Transaction tx;
        Drink drink = null;

        try{
            SessionFactory sessionFactory = hibernateConfig.hibernateConfiguration();
            session  = sessionFactory.openSession();
            tx= session.beginTransaction();

            drink = session.get(Drink.class,foodItem);

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return drink;
    }
}
