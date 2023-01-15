package com.ab.object.versioning.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    private static SessionFactory sessionFactory;

    static {
        try {
            // configure object
            Configuration configuration = new Configuration();
            //configuration.configure("com/ab/object/versioning/config/hibernate.cfg.xml");
           // build session factory
            sessionFactory = configuration.buildSessionFactory();
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
