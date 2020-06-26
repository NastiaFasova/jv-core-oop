package org.cars.sale.dao;

import org.cars.sale.model.Car;
import org.cars.sale.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarDao {

    public Car add(Car car) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
            return car;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Transaction failed");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
