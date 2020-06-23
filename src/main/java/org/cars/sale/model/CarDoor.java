package org.cars.sale.model;

public class CarDoor {
    private boolean doorOpened;
    private boolean windowOpened;

    public String info() {
        return "Information about CarDoor: " + "doorOpened="
                + doorOpened + ", windowOpened=" + windowOpened;
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
