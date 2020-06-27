package org.cars.sale;

import org.cars.sale.dao.CarWheelDao;
import org.cars.sale.dao.impl.CarDoorDaoImpl;
import org.cars.sale.dao.impl.CarWheelDaoImpl;
import org.cars.sale.model.CarWheel;
import org.cars.sale.service.WheelService;
import org.cars.sale.service.impl.CarDoorServiceImpl;
import org.cars.sale.service.impl.WheelServiceImpl;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CarWheelTest {

    private final CarWheel carWheel = new CarWheel();
    private static final double DELTA = 1e-15;

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private CarWheelDaoImpl carWheelDao;

    @InjectMocks
    private WheelServiceImpl wheelService;


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
