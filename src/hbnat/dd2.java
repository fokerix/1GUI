package hbnat;


public class dd2 {

    public static void main(String[] args) {
       /* try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session s = factory.openSession();
        Transaction tx = null;
        try {
            tx = s.beginTransaction();
            List employees = s.createQuery("FROM orders ").list();
            for (Object e : employees) {
                System.out.println(" " + e);
            }
            tx.commit();
        } catch (
                HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }*/
        DBquery dd = new DBquery();
        dd.returnAlloffices();


    }
}









