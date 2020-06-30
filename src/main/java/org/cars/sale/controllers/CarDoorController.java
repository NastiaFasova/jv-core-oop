package org.cars.sale.controllers;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.cars.sale.model.CarDoor;
import org.cars.sale.model.dto.CarDoorDto;
import org.cars.sale.model.mapper.CarDoorMapper;
import org.cars.sale.service.CarDoorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car-doors")
public class CarDoorController {
    private final CarDoorService carDoorService;
    private final CarDoorMapper carDoorMapper;

    public CarDoorController(CarDoorService carDoorService, CarDoorMapper carDoorMapper) {
        this.carDoorService = carDoorService;
        this.carDoorMapper = carDoorMapper;
    }

    @PostMapping
    public void add(@RequestBody @Valid CarDoorDto carDoorDto) {
        carDoorService.add(carDoorMapper.getCarDoor(carDoorDto));
    }

    @GetMapping
    public List<CarDoorDto> getAll() {
        List<CarDoor> carDoors = carDoorService.getAll();
        return carDoors.stream()
                .map(carDoorMapper::getCarDoorDto)
                .collect(Collectors.toList());
    }
}
