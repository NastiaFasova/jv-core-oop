package org.cars.sale.dao.impl;

import java.util.List;
import java.util.Optional;
import org.cars.sale.dao.CarDao;
import org.cars.sale.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {

    private final SessionFactory sessionFactory;

    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Car add(Car car) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
            return car;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Transaction failed. Car wasn't added into DB", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<Car> getById(long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Car car = session.get(Car.class, id);
            transaction.commit();
            return Optional.ofNullable(car);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Transaction failed. We can't get the car by its ID", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Car> getAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query<Car> query = session.createQuery("from Car", Car.class);
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving all cars", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
