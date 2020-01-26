package hbnat;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import entities.*;
import org.hibernate.query.Query;
import sun.awt.image.ImageWatched;

// CONFIGU ASTA FUNCTIONEAZA ASA CUM ESTE
public class DBquery {
    SessionFactory factory;
    public void returnAllEmployees()
    {

        List employees1 = new LinkedList();
        try
        {
                factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex)
        {
                System.err.println("Failed to create sessionFactory object." + ex);
                throw new ExceptionInInitializerError(ex);
        }
        Session s = factory.openSession();
        Transaction tx = null;
        try
        {
            tx = s.beginTransaction();
            employees1 = s.createQuery("FROM employees ").list();
            tx.commit();
        }

         catch (HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally
        {
            s.close();
        }
        for (Object e: employees1) {System.out.println(" " + e + " "); }
    }

    public void returnAlloffices()
    {
        List offices1 = new LinkedList();
        try
        {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex)
        {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session s = factory.openSession();
        Transaction tx = null;
        try
        {
            tx = s.beginTransaction();
            offices1 = s.createQuery("FROM offices ").list();
            tx.commit();
        }

        catch (HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally
        {
            s.close();
        }
        for (Object e: offices1)
        {
            System.out.println(" " + e + " ");
        }}
//Next method is WORKING WORKING WORKING WORKING WORKING WORKING WORKING WORKING WORKING WORKING WORKING WORKING WORKING WORKING WORKING:

        public void updateCustomer(int cno, String new_name) {
            try {
                factory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Failed to create sessionFactory object." + ex);
                throw new ExceptionInInitializerError(ex);
            }
            Session s = factory.openSession();
            Transaction tx = null;
            try {
                tx = s.beginTransaction();
                String query = "UPDATE customers SET customerName = '"+ new_name +"' WHERE customerNumber = '"+ cno+ "'";
                s.createSQLQuery(query).executeUpdate();


             tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                s.close();
            }
        }


}











