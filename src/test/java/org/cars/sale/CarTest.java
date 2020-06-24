package org.cars.sale;

import org.cars.sale.model.Car;
import org.cars.sale.model.CarDoor;
import org.cars.sale.model.CarWheel;
import org.cars.sale.service.CarService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class CarTest {
    private Car car = new Car(LocalDate.of(2013, 9, 9),
            "Petrol", 180, 15, 4);
    private static final double DELTA = 1e-15;
    private CarService carService = new CarService();
    @Before
    public void setUp() {
        CarWheel carWheel = new CarWheel();
        CarWheel []carWheels = {carWheel};
        car.setCarWheels(carWheels);

        CarDoor carDoor = new CarDoor();
        CarDoor []carDoors = {carDoor};
        car.setCarDoors(carDoors);
    }

    @Test
    public void changeSpeedCheck() {
        int firstSpeed = carService.changeCurrentSpeed(car, 100);
        Assert.assertEquals(car.getCurrentSpeed(), carService.changeCurrentSpeed(car, 100));
        int secondSpeed = carService.changeCurrentSpeed(car, 90);
        Assert.assertEquals(car.getCurrentSpeed(), 90);
    }

    @Test
    public void dropOffOnePassengerCheck() {
        car.setPassengerCount(20);
        carService.dropOffOnePassenger(car);
        Assert.assertEquals(car.getPassengerCount(), 19);
        carService.dropOffOnePassenger(car);
        Assert.assertEquals(car.getPassengerCount(), 18);
    }

    @Test
    public void dropOffAllPassengersCheck() {
        carService.dropOffAllPassengers(car);
        Assert.assertEquals(car.getPassengerCount(), 0);
    }

    @Test
    public void getDoorBuIndexCheck() {
        CarDoor carDoor = new CarDoor();
        CarDoor []carDoors = {carDoor};
        car.setCarDoors(carDoors);
        Assert.assertEquals(carService.getDoorByIndex(car,0), carDoor);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getDoorByNegativeIndexCheck () {
        carService.getDoorByIndex(car,-1);
        carService.getDoorByIndex(car,-2);
        carService.getDoorByIndex(car,-3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getDoorByGreatIndexCheck() {
        carService.getDoorByIndex(car,2);
    }

    @Test
    public void getWheelBuIndexCheck() {
        CarWheel carWheel = new CarWheel();
        CarWheel []carWheels = {carWheel};
        car.setCarWheels(carWheels);
        Assert.assertEquals(carService.getWheelByIndex(car,0), carWheel);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getWheelByNegativeIndexCheck () {
        carService.getWheelByIndex(car,-1);
        carService.getWheelByIndex(car,-2);
        carService.getWheelByIndex(car,-3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getWheelByGreatIndexCheck() {
        carService.getDoorByIndex(car,10);
    }

    @Test
    public void removeAllWheelsCheck() {
        carService.removeAllWheels(car);
        Assert.assertEquals(car.getCarWheels().length, 0);
    }

    @Test
    public void addWheelsCheck() {
        CarWheel firstCarWheel = new CarWheel();
        CarWheel secondCarWheel = new CarWheel();
        CarWheel []additionalCarWheels = {firstCarWheel, secondCarWheel};
        carService.addWheels(additionalCarWheels,2, car);
        Assert.assertEquals(3, car.getCarWheels().length);
    }

    @Test
    public void getMaxCurrentSpeedCheck() {
        CarWheel firstCarWheel = new CarWheel();
        CarWheel secondCarWheel = new CarWheel();
        CarWheel []carWheels = {firstCarWheel, secondCarWheel};
        firstCarWheel.setWheelCondition(0.6);
        secondCarWheel.setWheelCondition(0.8);
        car.setCarWheels(carWheels);
        car.setPassengerCount(4);
        Assert.assertEquals(108, carService.getMaxCurrentSpeed(car), DELTA);
    }

    @Test
    public void getMaxCurrentSpeedWithoutPassengersCheck() {
        car.setPassengerCount(0);
        Assert.assertEquals(0, carService.getMaxCurrentSpeed(car), DELTA);
    }
}
