package org.cars.sale.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

public class CarRequestDto {
    @NotNull(message = "ProductionDate of car can't be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate productionDate;
    @NotNull(message = "engineType of car can't be null")
    private String engineType;
    @NotNull(message = "maxSpeed of car can't be null")
    private long maxSpeed;
    @NotNull(message = "accelerationTime of car can't be null")
    private int accelerationTime;
    @NotNull(message = "passengerCapacity of car can't be null")
    private int passengerCapacity;
    @NotNull
    private long[] carWheels;
    @NotNull
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
