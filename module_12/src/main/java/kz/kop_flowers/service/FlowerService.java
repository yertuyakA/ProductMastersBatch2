package kz.kop_flowers.service;

import kz.kop_flowers.model.dto.FlowerDto;

import java.util.List;

public interface FlowerService {

    List<FlowerDto> getAllFlowers();

    FlowerDto getFlowerById(Integer id);

    FlowerDto createFlower(FlowerDto flower);

    FlowerDto deleteFlower(Integer id);

    List<FlowerDto> getFlowersByCategory(Integer id);

    FlowerDto updateFlower(Integer id, FlowerDto flower);
}
