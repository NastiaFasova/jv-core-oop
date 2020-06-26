package org.cars.sale;

import org.cars.sale.model.Car;
import org.cars.sale.model.CarDoor;
import org.cars.sale.model.CarWheel;
import org.cars.sale.service.CarDoorService;
import org.cars.sale.service.CarService;
import org.cars.sale.service.WheelService;

public class Main {
    public static void main(String[] args) {
        CarDoor carDoor = new CarDoor();
        carDoor.setDoorOpened(true);
        CarDoorService carDoorService = new CarDoorService();
        carDoorService.add(carDoor);

        CarWheel carWheel = new CarWheel();
        carWheel.setWheelCondition(0.9);
        WheelService wheelService = new WheelService();
        wheelService.add(carWheel);

        CarDoor[] carDoors = {carDoor};
        CarWheel[] carWheels = {carWheel};
        Car car = new Car.CarBuilder()
                .setCarDoors(carDoors)
                .setCarWheels(carWheels)
                .setCurrentSpeed(100)
                .setPassengerCount(2)
                .build();
        CarService carService = new CarService();
        carService.add(car);
    }
}
