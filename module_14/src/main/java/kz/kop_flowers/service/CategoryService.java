package kz.kop_flowers.service;

import kz.kop_flowers.model.dto.CategoryDto;
import kz.kop_flowers.model.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryDto getCategoryDtoById(Integer id);

    Category getCategoryById(Integer id);

    List<CategoryDto> getAllCategories();

    CategoryDto createCategory(CategoryDto categoryDto);
}
