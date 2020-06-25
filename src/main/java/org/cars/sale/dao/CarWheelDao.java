package org.cars.sale.dao;

import org.cars.sale.model.CarWheel;
import org.cars.sale.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarWheelDao {
    public CarWheel add(CarWheel carWheel) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(carWheel);
            transaction.commit();
            return carWheel;
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
