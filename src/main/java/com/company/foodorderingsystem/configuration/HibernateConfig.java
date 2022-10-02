package com.company.foodorderingsystem.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    public SessionFactory hibernateConfiguration() throws Exception {
        try{
            /**
             *  Hibernare Configuration
             */

            Configuration configuration = new Configuration().configure("foodorderingsystem.hbm.xml");
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            return sessionFactory;
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Error Configuring Session Factory ");
        }
    }
}
