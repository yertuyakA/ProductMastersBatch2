package kz.kop_flowers.service;

import kz.kop_flowers.model.FlowerMapper;
import kz.kop_flowers.model.dto.CategoryDto;
import kz.kop_flowers.model.entity.Category;
import kz.kop_flowers.model.exception.CategoryNotFoundException;
import kz.kop_flowers.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FlowerMapper mapper;

    @Override
    public CategoryDto getCategoryDtoById(Integer id) {
        return mapper.fromEntityToDto(getCategoryById(id));
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category is not found"));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(mapper::fromEntityToDto).toList();
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = Category.builder()
                .name(categoryDto.getName())
                .build();
        category = categoryRepository.save(category);
        return mapper.fromEntityToDto(category);
    }

}
