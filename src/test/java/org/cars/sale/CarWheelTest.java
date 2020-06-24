package org.cars.sale;

import org.cars.sale.model.CarWheel;
import org.cars.sale.service.WheelService;
import org.junit.Assert;
import org.junit.Test;

public class CarWheelTest {
    private WheelService wheelService = new WheelService();
    private CarWheel carWheel = new CarWheel();
    private static final double DELTA = 1e-15;

    @Test
    public void updateCheck() {
        wheelService.updateWheel(carWheel);
        Assert.assertEquals(carWheel.getWheelCondition(), 1, DELTA);
    }

    @Test
    public void eraseWheelCheck() {
        carWheel.setWheelCondition(1);
        wheelService.eraseWheel(carWheel, 20);
        Assert.assertEquals(0.8, carWheel.getWheelCondition(), DELTA);
    }
}
