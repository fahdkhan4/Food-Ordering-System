package com.company.foodorderingsystem.dao;

import com.company.foodorderingsystem.model.Cuisine;
import com.company.foodorderingsystem.model.Meal;
import com.company.foodorderingsystem.configuration.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MealDao {
    private HibernateConfig hibernateConfig = new HibernateConfig();

    /**
     *
     * @param meal
     * @throws Exception
     */
    public void saveMeal(Meal meal){
        Session session = null;
        try{
            SessionFactory sessionFactory = hibernateConfig.hibernateConfiguration();
            session  = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.save(meal);

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
     * @return List<Meal>
     * @throws Exception
     */
    public List<Meal> showMeals(){
        Session session = null;
        List<Meal>  meals = new ArrayList<>();
        try{
            SessionFactory sessionFactory = hibernateConfig.hibernateConfiguration();
            session  = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Meal");
            meals  = query.list();

            tx.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return meals;
    }

    /**
     *
     * @param id
     * @return Meal
     * @throws Exception
     */
    public Meal getMealById(Long id){
        Session session = null;
        Transaction tx = null;
        Meal meal = null;
        try{
            SessionFactory sessionFactory = hibernateConfig.hibernateConfiguration();
            session  = sessionFactory.openSession();
            tx= session.beginTransaction();
            meal = session.get(Meal.class,id);
            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return meal;
    }

    public Meal getMealByIdAndCuisineType(Long id,Long cuisineTypeId){

        Session session = null;
        Transaction tx = null;
        Meal meal = null;
        try{
            SessionFactory sessionFactory = hibernateConfig.hibernateConfiguration();
            session  = sessionFactory.openSession();
            tx= session.beginTransaction();

            String hqlQuery = "SELECT m FROM Meal m JOIN FETCH m.cuisine_type cuisine WHERE m.id = :id AND cuisine.id = :cuisine_id";
            Query query = session.createQuery(hqlQuery,Meal.class);
            query.setParameter("id",id);
            query.setParameter("cuisine_id",cuisineTypeId);


            List<Meal> mealList = query.list();
            if(!mealList.isEmpty()){
                meal = mealList.get(0);
            }

            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return meal;
    }

    public List<Meal> getMealByCuisineTypeDao(Cuisine cuisine) {

        Session session =null;
        Transaction tx = null;
        List<Meal> meals = new ArrayList<>();
        try{
            SessionFactory sessionFactory = hibernateConfig.hibernateConfiguration();
            session = sessionFactory.openSession();
            tx= session.beginTransaction();

            String hqlQuery = "SELECT m FROM Meal m JOIN FETCH m.cuisine_type cuisine WHERE cuisine = :cuisine";
            Query query = session.createQuery(hqlQuery,Meal.class);
            query.setParameter("cuisine",cuisine);

            tx.commit();
            meals = query.list();

        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return meals;
    }
}
