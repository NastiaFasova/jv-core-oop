package org.cars.sale.model;

import java.time.LocalDate;
import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import org.cars.sale.service.CarService;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate productionDate;
    private String engineType;
    private long maxSpeed;
    private int accelerationTime;
    private int passengerCapacity;
    private int passengerCount;
    private int currentSpeed;

    @OneToMany
    @OrderColumn(name = "car_wheels")
    private CarWheel []carWheels;

    @OneToMany
    @OrderColumn(name = "car_doors")
    private CarDoor []carDoors;

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

    public Car() {
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public void setCarDoors(CarDoor[] carDoors) {
        this.carDoors = carDoors;
    }

    public void setCarWheels(CarWheel[] carWheels) {
        this.carWheels = carWheels;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
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
        private LocalDate productionDate;
        private String engineType;
        private long maxSpeed;
        private int accelerationTime;
        private int passengerCapacity;
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

        public CarBuilder() {
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
