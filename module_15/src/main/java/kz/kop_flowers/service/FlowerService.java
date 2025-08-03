package kz.kop_flowers.service;

import kz.kop_flowers.model.dto.FlowerDto;

import java.util.List;

public interface FlowerService {

    List<FlowerDto> getAllFlowers();

    FlowerDto getFlowerById(Integer id);

    FlowerDto createFlower(FlowerDto flower);
}
