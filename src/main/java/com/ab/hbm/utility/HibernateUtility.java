package com.ab.hbm.utility;

import com.ab.hbm.entity.MobilePhoneUser;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtility {
    private static SessionFactory sessionFactory;

    static {
        try {
            // configure object
            Configuration configuration = new Configuration();
            /*configuration.configure("com/ab/hbm/config/hibernate.cfg.xml");*/
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/for_hibernate");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "manager");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

            settings.put(Environment.SHOW_SQL, "true");

            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            settings.put(Environment.HBM2DDL_AUTO, "update");

            configuration.setProperties(settings);
            configuration.addAnnotatedClass(MobilePhoneUser.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            // build session factory
            //sessionFactory = configuration.buildSessionFactory();
           sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory != null)
            return sessionFactory;
        else
            throw new RuntimeException("Invalid Session Factory object creation");
    }

    public static Session getSession() {
        Session session = null;
        if (sessionFactory != null) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public static void closeSession(Session session){
        if(session != null)
            session.close();
    }

    public static void closeSessionFactory(){
        if(sessionFactory != null)
            sessionFactory.close();
    }
}
