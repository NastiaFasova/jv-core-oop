package org.cars.sale.dao;

import java.util.List;
import java.util.Optional;
import org.cars.sale.model.CarDoor;

public interface CarDoorDao {
    CarDoor add(CarDoor carDoor);

    Optional<CarDoor> getById(Long id);

    List<CarDoor> getAll();
}
