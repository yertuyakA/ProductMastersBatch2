package kz.kop_flowers.service;

import kz.kop_flowers.model.FlowerMapper;
import kz.kop_flowers.model.dto.FlowerDto;
import kz.kop_flowers.model.entity.Category;
import kz.kop_flowers.model.entity.Flower;
import kz.kop_flowers.model.exception.FlowerNotFoundException;
import kz.kop_flowers.repository.FlowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlowerServiceImpl implements FlowerService {

    private final FlowerRepository flowerRepository;
    private final FlowerMapper mapper;
    private final CategoryService categoryService;

    @Override
    public List<FlowerDto> getAllFlowers() {
        List<Flower> flowers = flowerRepository.findAll();
        return flowers.stream()
                .map(mapper::fromEntityToDto)
                .toList();
    }

    @Override
    public FlowerDto getFlowerById(Integer id) {
        Flower flower = flowerRepository.findById(id).orElseThrow(() -> new FlowerNotFoundException("Flower does not exist"));
        return mapper.fromEntityToDto(flower);
    }

    @Override
    public FlowerDto createFlower(FlowerDto flowerDto) {
        Flower flower = Flower.builder()
                .name(flowerDto.getName())
                .price(flowerDto.getPrice())
                .size(flowerDto.getSize())
                .category(categoryService.getCategoryById(flowerDto.getCategory().getId()))
                .build();
        flower = flowerRepository.save(flower);
        return mapper.fromEntityToDto(flower);
    }

    @Override
    public FlowerDto deleteFlower(Integer id) {
        Flower flower = flowerRepository.findById(id).orElseThrow(() -> new FlowerNotFoundException("Flower does not exist"));
        flowerRepository.delete(flower);
        return mapper.fromEntityToDto(flower);
    }

    @Override
    public List<FlowerDto> getFlowersByCategory(Integer categoryId) {
        List<Flower> flowers = flowerRepository.findByCategoryId(categoryId);
        return flowers.stream().map(mapper::fromEntityToDto).toList();
    }

    @Override
    public FlowerDto updateFlower(Integer id, FlowerDto updatedFlower) {
        Flower flowerToUpdate = flowerRepository.findById(id).orElseThrow(() -> new FlowerNotFoundException("Flower does not exist"));
        flowerToUpdate.setName(updatedFlower.getName());
        flowerToUpdate.setPrice(updatedFlower.getPrice());
        flowerToUpdate.setSize(updatedFlower.getSize());
        if (flowerToUpdate.getCategory() != null) {
            Category category = categoryService.getCategoryById(updatedFlower.getCategory().getId());
            flowerToUpdate.setCategory(category);
        }
        return mapper.fromEntityToDto(flowerRepository.save(flowerToUpdate));
    }
}
