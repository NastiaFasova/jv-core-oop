package org.cars.sale.dao;

import org.cars.sale.model.CarDoor;
import org.cars.sale.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarDoorDao {
    public CarDoor add(CarDoor carDoor) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(carDoor);
            transaction.commit();
            return carDoor;
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
