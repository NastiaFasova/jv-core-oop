package org.cars.sale.service;

import java.util.List;
import org.cars.sale.model.Car;
import org.cars.sale.model.CarDoor;
import org.cars.sale.model.CarWheel;

public interface CarService {
    int changeCurrentSpeed(Car car, int speed);

    int dropOffOnePassenger(Car car);

    int dropOffAllPassengers(Car car);

    CarDoor getDoorByIndex(Car car, int index);

    CarWheel getWheelByIndex(Car car, int index);

    CarWheel[] removeAllWheels(Car car);

    CarWheel[] addWheels(CarWheel[] additional, Car car);

    double getMaxCurrentSpeed(Car car);

    Car add(Car car);

    Car getById(long id);

    List<Car> getAll();
}
