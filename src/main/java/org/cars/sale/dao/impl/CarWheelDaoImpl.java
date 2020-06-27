package org.cars.sale.dao.impl;

import java.util.List;
import java.util.Optional;
import org.cars.sale.dao.CarWheelDao;
import org.cars.sale.model.CarWheel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CarWheelDaoImpl implements CarWheelDao {

    private final SessionFactory sessionFactory;

    public CarWheelDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CarWheel add(CarWheel carWheel) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
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

    @Override
    public Optional<CarWheel> getById(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            CarWheel carWheel = session.get(CarWheel.class, id);
            transaction.commit();
            return Optional.ofNullable(carWheel);
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

    @Override
    public List<CarWheel> getAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query<CarWheel> query = session.createQuery("from CarWheel", CarWheel.class);
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving all carWheel", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
