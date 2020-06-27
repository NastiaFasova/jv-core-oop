package org.cars.sale.model.dto;

import java.time.LocalDate;

public class CarResponseDto {
    private Long carId;
    private LocalDate productionDate;
    private String engineType;
    private long maxSpeed;
    private int accelerationTime;
    private int passengerCapacity;
    private long[] carWheels;
    private long[] carDoors;

    public long[] getCarWheels() {
        return carWheels;
    }

    public void setCarWheels(long[] carWheels) {
        this.carWheels = carWheels;
    }

    public long[] getCarDoors() {
        return carDoors;
    }

    public void setCarDoors(long[] carDoors) {
        this.carDoors = carDoors;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public long getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(int accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
