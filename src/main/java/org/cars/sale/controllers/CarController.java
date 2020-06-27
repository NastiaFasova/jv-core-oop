package org.cars.sale.controllers;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.cars.sale.model.Car;
import org.cars.sale.model.dto.CarRequestDto;
import org.cars.sale.model.dto.CarResponseDto;
import org.cars.sale.model.mapper.CarDoorMapper;
import org.cars.sale.model.mapper.CarMapper;
import org.cars.sale.model.mapper.CarWheelMapper;
import org.cars.sale.service.CarService;
import org.cars.sale.service.WheelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;
    private final CarDoorMapper carDoorMapper;
    private final CarWheelMapper carWheelMapper;
    private final WheelService wheelService;

    public CarController(CarService carService, CarMapper carMapper,
                         CarDoorMapper carDoorMapper, CarWheelMapper carWheelMapper,
                         WheelService wheelService) {
        this.carService = carService;
        this.carMapper = carMapper;
        this.carDoorMapper = carDoorMapper;
        this.carWheelMapper = carWheelMapper;
        this.wheelService = wheelService;
    }

    @PostMapping("/add")
    public void add(@RequestBody @Valid CarRequestDto carRequestDto) {
        carService.add(carMapper.getCarFromRequest(carRequestDto));
    }

    @GetMapping("/")
    public List<CarResponseDto> getAll() {
        List<Car> cars = carService.getAll();
        return cars.stream()
                .map(carMapper::getCarResponseDto)
                .collect(Collectors.toList());
    }
}
