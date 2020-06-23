package org.cars.sale;

import org.cars.sale.model.CarDoor;
import org.cars.sale.service.CarDoorService;
import org.junit.Assert;
import org.junit.Test;

public class CarDoorTest {
    private final CarDoorService carDoorService = new CarDoorService();
    private final CarDoor carDoor = new CarDoor();


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
