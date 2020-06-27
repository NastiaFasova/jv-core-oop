package org.cars.sale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_door")
public class CarDoor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean doorOpened;
    private boolean windowOpened;

    public String info() {
        return "Information about CarDoor: " + "doorOpened="
                + doorOpened + ", windowOpened=" + windowOpened;
    }

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

    public boolean isWindowOpened() {
        return windowOpened;
    }

    public void setWindowOpened(boolean windowOpened) {
        this.windowOpened = windowOpened;
    }
}
