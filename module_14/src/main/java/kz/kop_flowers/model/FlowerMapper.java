package kz.kop_flowers.model;

import kz.kop_flowers.model.dto.CategoryDto;
import kz.kop_flowers.model.dto.FlowerDto;
import kz.kop_flowers.model.entity.Category;
import kz.kop_flowers.model.entity.Flower;
import org.springframework.stereotype.Component;

@Component
public class FlowerMapper {

    public FlowerDto fromEntityToDto(Flower flower) {
        return FlowerDto.builder()
                .id(flower.getId())
                .name(flower.getName())
                .price(flower.getPrice())
                .size(flower.getSize())
                .category(fromEntityToDto(flower.getCategory()))
                .build();
    }

    public CategoryDto fromEntityToDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
