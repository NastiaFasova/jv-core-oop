package org.cars.sale.service;

import org.cars.sale.dao.CarWheelDao;
import org.cars.sale.model.CarWheel;

public class WheelService {

    private final CarWheelDao carWheelDao = new CarWheelDao();

    public double updateWheel(CarWheel carWheel) {
        carWheel.setWheelCondition(1);
        return carWheel.getWheelCondition();
    }

    public double eraseWheel(CarWheel carWheel, int percentage) {
        carWheel.setWheelCondition(carWheel.getWheelCondition()
                - percentage * carWheel.getWheelCondition() / 100);
        return carWheel.getWheelCondition();
    }

    public CarWheel add(CarWheel carWheel) {
        return carWheelDao.add(carWheel);
    }
}
