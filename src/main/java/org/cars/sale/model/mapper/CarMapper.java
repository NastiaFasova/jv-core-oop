package org.cars.sale.model.mapper;

import java.util.Arrays;
import org.cars.sale.model.Car;
import org.cars.sale.model.CarDoor;
import org.cars.sale.model.CarWheel;
import org.cars.sale.model.dto.CarRequestDto;
import org.cars.sale.model.dto.CarResponseDto;
import org.cars.sale.service.CarDoorService;
import org.cars.sale.service.WheelService;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    private final WheelService wheelService;
    private final CarDoorService carDoorService;

    public CarMapper(WheelService wheelService, CarDoorService carDoorService) {
        this.wheelService = wheelService;
        this.carDoorService = carDoorService;
    }

    public CarResponseDto getCarResponseDto(Car car) {
        CarResponseDto carResponseDto = new CarResponseDto();
        carResponseDto.setCarId(car.getId());
        carResponseDto.setProductionDate(car.getProductionDate());
        carResponseDto.setAccelerationTime(car.getAccelerationTime());
        carResponseDto.setEngineType(car.getEngineType());
        carResponseDto.setPassengerCapacity(car.getPassengerCapacity());
        carResponseDto.setMaxSpeed(car.getMaxSpeed());
        carResponseDto.setCarDoors(Arrays.stream(car.getCarDoor())
                .mapToLong(CarDoor::getId).toArray());
        carResponseDto.setCarWheels(Arrays.stream(car.getCarWheels())
                .mapToLong(CarWheel::getId).toArray());
        return carResponseDto;
    }

    public Car getCarFromRequest(CarRequestDto carRequestDto) {
        Car car = new Car();
        car.setProductionDate(carRequestDto.getProductionDate());
        car.setAccelerationTime(carRequestDto.getAccelerationTime());
        car.setEngineType(carRequestDto.getEngineType());
        car.setPassengerCapacity(carRequestDto.getPassengerCapacity());
        car.setMaxSpeed(carRequestDto.getMaxSpeed());
        CarWheel[] carWheels = new CarWheel[carRequestDto.getCarWheels().length];
        for (int i = 0; i < carWheels.length; i++) {
            carWheels[i] = wheelService.getById(carRequestDto.getCarWheels()[i]);
        }
        car.setCarWheels(carWheels);
        CarDoor[] carDoors = new CarDoor[carRequestDto.getCarDoors().length];
        for (int i = 0; i < carDoors.length; i++) {
            carDoors[i] = carDoorService.getById(carRequestDto.getCarDoors()[i]);
        }
        car.setCarDoors(carDoors);
        car.setCarDoors(carDoors);
        return car;
    }
}
