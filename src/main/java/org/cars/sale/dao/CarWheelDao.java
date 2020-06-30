package org.cars.sale.dao;

import java.util.List;
import java.util.Optional;
import org.cars.sale.model.CarWheel;

public interface CarWheelDao {
    CarWheel add(CarWheel carWheel);

    Optional<CarWheel> getById(Long id);

    List<CarWheel> getAll();
}
