package org.cars.sale.model.dto;

import javax.validation.constraints.NotNull;

public class CarDoorDto {
    @NotNull(message = "CarDoorId can't be null")
    private Long id;
    @NotNull(message = "Door should be either opened or closed")
    private boolean doorOpened;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDoorOpened() {
        return doorOpened;
    }

    public void setDoorOpened(boolean doorOpened) {
        this.doorOpened = doorOpened;
    }

}
