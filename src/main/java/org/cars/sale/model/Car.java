package org.cars.sale.model;

import java.time.LocalDate;
import java.util.Arrays;
import org.cars.sale.service.CarService;

public class Car {
    private final LocalDate productionDate;
    private final String engineType;
    private final long maxSpeed;
    private final int accelerationTime;
    private final int passengerCapacity;
    private int passengerCount;
    private int currentSpeed;
    private CarWheel[]carWheels;
    private CarDoor[]carDoors;

    private Car(CarBuilder carBuilder) {
        this.productionDate = carBuilder.productionDate;
        this.engineType = carBuilder.engineType;
        this.maxSpeed = carBuilder.maxSpeed;
        this.accelerationTime = carBuilder.accelerationTime;
        this.passengerCapacity = carBuilder.passengerCapacity;
        this.passengerCount = carBuilder.passengerCount;
        this.currentSpeed = carBuilder.currentSpeed;
        this.carWheels = carBuilder.carWheels;
        this.carDoors = carBuilder.carDoors;
    }

    public Car(LocalDate productionDate, String engineType, long maxSpeed,
               int accelerationTime, int passengerCapacity) {
        this.productionDate = productionDate;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.accelerationTime = accelerationTime;
        this.passengerCapacity = passengerCapacity;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public String getEngineType() {
        return engineType;
    }

    public long getMaxSpeed() {
        return maxSpeed;
    }

    public int getAccelerationTime() {
        return accelerationTime;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public CarWheel[] getCarWheels() {
        return carWheels;
    }

    public CarDoor[] getCarDoor() {
        return carDoors;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void setCarWheels(CarWheel[] carWheels) {
        this.carWheels = carWheels;
    }

    public void setCarDoors(CarDoor[] carDoors) {
        this.carDoors = carDoors;
    }

    public String info() {
        CarService carService = new CarService();
        return "Information about Car:" + "productionDate=" + productionDate
                + ", engineType='" + engineType + '\''
                + ", maxSpeed=" + maxSpeed
                + ", accelerationTime=" + accelerationTime
                + ", passengerCapacity=" + passengerCapacity
                + ", passengerCount=" + passengerCount
                + ", currentSpeed=" + currentSpeed
                + ", carWheels=" + Arrays.toString(carWheels)
                + ", carDoors=" + Arrays.toString(carDoors)
                + "maxCurrentSpeed=" + carService.getMaxCurrentSpeed(this);
    }

    public static class CarBuilder {
        private final LocalDate productionDate;
        private final String engineType;
        private final long maxSpeed;
        private final int accelerationTime;
        private final int passengerCapacity;
        private int passengerCount;
        private int currentSpeed;
        private CarWheel[]carWheels;
        private CarDoor[]carDoors;

        public CarBuilder(LocalDate productionDate, String engineType,
                          long maxSpeed, int accelerationTime, int passengerCapacity
        ) {
            this.productionDate = productionDate;
            this.engineType = engineType;
            this.maxSpeed = maxSpeed;
            this.accelerationTime = accelerationTime;
            this.passengerCapacity = passengerCapacity;

        }

        public CarBuilder setPassengerCount(int passengerCount) {
            this.passengerCount = passengerCount;
            return this;
        }

        public CarBuilder setCurrentSpeed(int currentSpeed) {
            this.currentSpeed = currentSpeed;
            return this;
        }

        public CarBuilder setCarWheels(CarWheel[] carWheels) {
            this.carWheels = carWheels;
            return this;
        }

        public CarBuilder setCarDoors(CarDoor[] carDoors) {
            this.carDoors = carDoors;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
