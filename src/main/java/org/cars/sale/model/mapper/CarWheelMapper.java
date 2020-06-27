package org.cars.sale.model.mapper;

import org.cars.sale.model.CarWheel;
import org.cars.sale.model.dto.CarWheelDto;
import org.springframework.stereotype.Component;

@Component
public class CarWheelMapper {
    public CarWheelDto getCarWheelDto(CarWheel carWheel) {
        CarWheelDto carWheelDto = new CarWheelDto();
        carWheelDto.setId(carWheel.getId());
        carWheelDto.setWheelCondition(carWheel.getWheelCondition());
        return carWheelDto;
    }

    public CarWheel getCarWheel(CarWheelDto carWheelDto) {
        CarWheel carWheel = new CarWheel();
        carWheel.setWheelCondition(carWheelDto.getWheelCondition());
        carWheel.setId(carWheelDto.getId());
        return carWheel;
    }
}
