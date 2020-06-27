package org.cars.sale.service;

import java.util.List;
import org.cars.sale.model.CarDoor;

public interface CarDoorService {
    boolean openDoor(CarDoor door);

    boolean openWindow(CarDoor door);

    boolean openOrCloseWindow(CarDoor window);

    boolean openOrCloseDoor(CarDoor door);

    boolean closeWindow(CarDoor window);

    boolean closeDoor(CarDoor door);

    CarDoor add(CarDoor carDoor);

    CarDoor getById(Long id);

    List<CarDoor> getAll();
}
