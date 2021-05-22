package com.example.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DBFactory {
    private static DBFactory dbFactory = null;


    private SessionFactory sessionFactory;


    private DBFactory() {
        Configuration configuration  = new Configuration().configure();
        configuration.addAnnotatedClass(com.example.services.product.to.Product.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    public static DBFactory getDBFactory() {
        if (dbFactory == null) {
            dbFactory = new DBFactory();
        }
        return dbFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
