package org.cars.sale.dao.impl;

import java.util.List;
import java.util.Optional;
import org.cars.sale.dao.CarDoorDao;
import org.cars.sale.model.CarDoor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CarDoorDaoImpl implements CarDoorDao {

    private final SessionFactory sessionFactory;

    public CarDoorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CarDoor add(CarDoor carDoor) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
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

    @Override
    public Optional<CarDoor> getById(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            CarDoor carDoor = session.get(CarDoor.class, id);
            transaction.commit();
            return Optional.ofNullable(carDoor);
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
    public List<CarDoor> getAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query<CarDoor> query = session.createQuery("from CarDoor", CarDoor.class);
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving all carDoors", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
