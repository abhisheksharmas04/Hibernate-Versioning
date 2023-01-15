package com.ab.object.versioning;

import com.ab.object.versioning.entity.MobilePhoneUser;
import com.ab.object.versioning.utility.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App{
    public static void main( String[] args ){
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = HibernateUtility.getSession();

        try{
            Transaction transaction = session.beginTransaction();
            MobilePhoneUser user = new MobilePhoneUser();
            user.setMobileNo(9828838807L);
            user.setPrepaid(true);
            user.setCircle("Raj");
            user.setCallerTune("Hello tunes");

            session.save(user);

            /*MobilePhoneUser mobilePhoneUser = session.get(MobilePhoneUser.class,1);
            if(mobilePhoneUser == null)
                System.out.println("No user found with id: " + 1L);
            else {
                mobilePhoneUser.setCallerTune("JJJJ");
                mobilePhoneUser.setCircle("DEL");
                session.update(mobilePhoneUser);
            }*/

            transaction.commit();
        }catch (HibernateException hbe){
            hbe.printStackTrace();
            System.out.println("Error: " + hbe.getMessage());
        }finally {
            HibernateUtility.closeSession(session);
            HibernateUtility.closeSessionFactory();
        }

    }
}
