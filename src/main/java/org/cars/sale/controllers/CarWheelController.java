package org.cars.sale.controllers;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.cars.sale.model.CarWheel;
import org.cars.sale.model.dto.CarWheelDto;
import org.cars.sale.model.mapper.CarWheelMapper;
import org.cars.sale.service.WheelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car-wheels")
public class CarWheelController {

    private final WheelService wheelService;
    private final CarWheelMapper carWheelMapper;

    public CarWheelController(WheelService wheelService, CarWheelMapper carWheelMapper) {
        this.wheelService = wheelService;
        this.carWheelMapper = carWheelMapper;
    }

    @PostMapping("/add")
    public void add(@RequestBody @Valid CarWheelDto carWheelDto) {
        wheelService.add(carWheelMapper.getCarWheel(carWheelDto));
    }

    @GetMapping("/")
    public List<CarWheelDto> getAll() {
        List<CarWheel> carWheels = wheelService.getAll();
        return carWheels.stream()
                .map(carWheelMapper::getCarWheelDto)
                .collect(Collectors.toList());
    }
}
