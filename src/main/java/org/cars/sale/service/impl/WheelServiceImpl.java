package org.cars.sale.service.impl;

import java.util.List;
import org.cars.sale.dao.CarWheelDao;
import org.cars.sale.model.CarWheel;
import org.cars.sale.service.WheelService;
import org.springframework.stereotype.Service;

@Service
public class WheelServiceImpl implements WheelService {

    private final CarWheelDao carWheelDao;

    public WheelServiceImpl(CarWheelDao carWheelDao) {
        this.carWheelDao = carWheelDao;
    }

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

    @Override
    public CarWheel getById(Long id) {
        return carWheelDao.getById(id).orElseThrow();
    }

    @Override
    public List<CarWheel> getAll() {
        return carWheelDao.getAll();
    }
}
