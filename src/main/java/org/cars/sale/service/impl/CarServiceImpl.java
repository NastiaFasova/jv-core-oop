package org.cars.sale.service.impl;

import java.util.Arrays;
import java.util.List;
import org.cars.sale.dao.CarDao;
import org.cars.sale.model.Car;
import org.cars.sale.model.CarDoor;
import org.cars.sale.model.CarWheel;
import org.cars.sale.service.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    public int changeCurrentSpeed(Car car, int speed) {
        car.setCurrentSpeed(speed);
        return speed;
    }

    public int dropOffOnePassenger(Car car) {
        car.setPassengerCount(car.getPassengerCount() - 1);
        return car.getPassengerCount();
    }

    public int dropOffAllPassengers(Car car) {
        car.setPassengerCount(0);
        return car.getPassengerCount();
    }

    public CarDoor getDoorByIndex(Car car, int index) {
        CarDoor []carDoors = car.getCarDoor();
        return carDoors[index];
    }

    public CarWheel getWheelByIndex(Car car, int index) {
        CarWheel [] carWheels = car.getCarWheels();
        return carWheels[index];
    }

    public CarWheel[] removeAllWheels(Car car) {
        car.setCarWheels(new CarWheel[0]);
        return car.getCarWheels();
    }

    public CarWheel[] addWheels(CarWheel[] additional, Car car) {
        CarWheel[] resultedWheels = new CarWheel[additional.length + car.getCarWheels().length];
        System.arraycopy(car.getCarWheels(), 0, resultedWheels,
                0, car.getCarWheels().length);
        System.arraycopy(additional, 0, resultedWheels,
                car.getCarWheels().length, additional.length);
        car.setCarWheels(resultedWheels);
        return car.getCarWheels();
    }

    public double getMaxCurrentSpeed(Car car) {
        if (car.getPassengerCount() == 0) {
            return 0;
        }
        Double mostErasedWheelCondition = Arrays.stream(car.getCarWheels())
                .map(CarWheel::getWheelCondition)
                .min(Double::compareTo).orElseThrow();
        return mostErasedWheelCondition * car.getMaxSpeed();
    }

    public Car add(Car car) {
        return carDao.add(car);
    }

    @Override
    public Car getById(long id) {
        return carDao.getById(id).orElseThrow();
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }
}
