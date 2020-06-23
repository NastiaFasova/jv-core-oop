package org.cars.sale.service;

import java.time.LocalDate;
import java.util.Arrays;
import org.cars.sale.model.Car;
import org.cars.sale.model.CarDoor;
import org.cars.sale.model.CarWheel;

public class CarService {
    private final Car car = new Car(LocalDate.of(2013, 9, 9),
            "Petrol", 180, 15, 4);

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

    public CarWheel[] addWheels(CarWheel[] additional, int count, Car car) {
        CarWheel[] carWheels = car.getCarWheels();
        CarWheel[] prevWheels = carWheels;
        carWheels = new CarWheel[prevWheels.length + additional.length];
        System.arraycopy(prevWheels, 0, carWheels, 0, prevWheels.length);
        System.arraycopy(additional, 0, carWheels, prevWheels.length, additional.length);
        car.setCarWheels(carWheels);
        return carWheels;
    }

    public double getMaxCurrentSpeed(Car car) {
        if (car.getPassengerCount() == 0) {
            return 0;
        }
        Double mostErasedWheelCondition = Arrays.stream(car.getCarWheels())
                .map(CarWheel::getWheelCondition)
                .min(Double::compareTo).get();
        return mostErasedWheelCondition * car.getMaxSpeed();
    }

}
