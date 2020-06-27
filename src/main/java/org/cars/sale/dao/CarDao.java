package org.cars.sale.dao;

import java.util.List;
import java.util.Optional;
import org.cars.sale.model.Car;

public interface CarDao {

    Car add(Car car);

    Optional<Car> getById(long id);

    List<Car> getAll();
}
