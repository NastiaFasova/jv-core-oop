package org.cars.sale.service;

import java.util.List;
import org.cars.sale.model.CarWheel;

public interface WheelService {
    double updateWheel(CarWheel carWheel);

    double eraseWheel(CarWheel carWheel, int percentage);

    CarWheel add(CarWheel carWheel);

    CarWheel getById(Long id);

    List<CarWheel> getAll();
}
