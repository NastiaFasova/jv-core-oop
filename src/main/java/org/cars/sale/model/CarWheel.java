package org.cars.sale.model;

public class CarWheel {
    private double wheelCondition;

    public double getWheelCondition() {
        return wheelCondition;
    }

    public String info() {
        return "Information about CarWheel:"
                + "wheelCondition=" + wheelCondition;
    }

    public void setWheelCondition(double wheelCondition) {
        this.wheelCondition = wheelCondition;
    }
}
