package org.cars.sale.model.mapper;

import org.cars.sale.model.CarDoor;
import org.cars.sale.model.dto.CarDoorDto;
import org.springframework.stereotype.Component;

@Component
public class CarDoorMapper {
    public CarDoorDto getCarDoorDto(CarDoor carDoor) {
        CarDoorDto carDoorDto = new CarDoorDto();
        carDoorDto.setId(carDoor.getId());
        carDoorDto.setDoorOpened(carDoor.isDoorOpened());
        return carDoorDto;
    }

    public CarDoor getCarDoor(CarDoorDto carDoorDto) {
        CarDoor carDoor = new CarDoor();
        carDoor.setDoorOpened(carDoorDto.isDoorOpened());
        return carDoor;
    }
}
