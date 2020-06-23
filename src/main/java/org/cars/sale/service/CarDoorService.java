package org.cars.sale.service;

import org.cars.sale.model.CarDoor;

public class CarDoorService {

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
}
