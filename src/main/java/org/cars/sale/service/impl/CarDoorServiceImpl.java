package org.cars.sale.service.impl;

import java.util.List;
import org.cars.sale.dao.CarDoorDao;
import org.cars.sale.model.CarDoor;
import org.cars.sale.service.CarDoorService;
import org.springframework.stereotype.Service;

@Service
public class CarDoorServiceImpl implements CarDoorService {

    private final CarDoorDao carDoorDao;

    public CarDoorServiceImpl(CarDoorDao carDoorDao) {
        this.carDoorDao = carDoorDao;
    }

    public boolean openDoor(CarDoor door) {
        door.setDoorOpened(true);
        return true;
    }

    public boolean openWindow(CarDoor door) {
        door.setWindowOpened(true);
        return true;
    }

    public boolean openOrCloseWindow(CarDoor window) {
        return window.isWindowOpened() ? closeWindow(window) : openWindow(window);
    }

    public boolean openOrCloseDoor(CarDoor door) {
        return door.isDoorOpened() ? closeDoor(door) : openDoor(door);
    }

    public boolean closeWindow(CarDoor window) {
        window.setWindowOpened(false);
        return true;
    }

    public boolean closeDoor(CarDoor door) {
        door.setDoorOpened(false);
        return true;
    }

    public CarDoor add(CarDoor carDoor) {
        return carDoorDao.add(carDoor);
    }

    @Override
    public CarDoor getById(Long id) {
        return carDoorDao.getById(id).orElseThrow();
    }

    @Override
    public List<CarDoor> getAll() {
        return carDoorDao.getAll();
    }
}
