package org.cars.sale;

import org.cars.sale.dao.CarDoorDao;
import org.cars.sale.dao.impl.CarDoorDaoImpl;
import org.cars.sale.model.CarDoor;
import org.cars.sale.service.CarDoorService;
import org.cars.sale.service.impl.CarDoorServiceImpl;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CarDoorTest {
    private final CarDoor carDoor = new CarDoor();
    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private CarDoorDaoImpl carDoorDao;

    @InjectMocks
    private CarDoorServiceImpl carDoorService;

    @Test
    public void openDoorCheck() {
        carDoorService.openDoor(carDoor);
        Assert.assertTrue(carDoor.isDoorOpened());
    }

    @Test
    public void openWindowCheck() {
        carDoorService.openWindow(carDoor);
        Assert.assertTrue(carDoor.isWindowOpened());
    }

    @Test
    public void openOrCloseDoorCheck() {
        boolean doorCondition = carDoor.isDoorOpened();
        Assert.assertEquals(carDoorService.openOrCloseDoor(carDoor), !doorCondition);
    }

    @Test
    public void openOrCloseWindowCheck() {
        boolean windowCondition = carDoor.isWindowOpened();
        Assert.assertEquals(carDoorService.openOrCloseWindow(carDoor), !windowCondition);
    }

    @Test
    public void closeWindowCheck() {
        carDoorService.closeWindow(carDoor);
        Assert.assertFalse(carDoor.isWindowOpened());
    }

    @Test
    public void closeDoorCheck() {
        carDoorService.closeDoor(carDoor);
        Assert.assertFalse(carDoor.isDoorOpened());
    }

}
