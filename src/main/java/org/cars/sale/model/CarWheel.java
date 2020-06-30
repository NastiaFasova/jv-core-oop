package org.cars.sale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_wheel")
public class CarWheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double wheelCondition;

    public double getWheelCondition() {
        return wheelCondition;
    }

    public String info() {
        return "Information about CarWheel:"
                + "wheelCondition=" + wheelCondition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWheelCondition(double wheelCondition) {
        this.wheelCondition = wheelCondition;
    }
}
