package org.cars.sale.model.dto;

import javax.validation.constraints.NotNull;

public class CarWheelDto {
    @NotNull(message = "CarWheel can't be null")
    private Long id;
    @NotNull(message = "CarWheel should have a wheelCondition")
    private double wheelCondition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWheelCondition() {
        return wheelCondition;
    }

    public void setWheelCondition(double wheelCondition) {
        this.wheelCondition = wheelCondition;
    }
}
