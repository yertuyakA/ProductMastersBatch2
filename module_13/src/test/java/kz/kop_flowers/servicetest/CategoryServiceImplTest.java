package kz.kop_flowers.servicetest;

import kz.kop_flowers.model.FlowerMapper;
import kz.kop_flowers.model.dto.CategoryDto;
import kz.kop_flowers.model.entity.Category;
import kz.kop_flowers.model.exception.CategoryNotFoundException;
import kz.kop_flowers.repository.CategoryRepository;
import kz.kop_flowers.service.CategoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FlowerMapper mapper;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    public void testGetAllCategories() {
        List<Category> categoryList = List.of(
                Category.builder().id(1).name("Funeral flowers").build(),
                Category.builder().id(2).name("Wedding flowers").build()
        );

        List<CategoryDto> categoryDtoList = List.of(
                CategoryDto.builder().name("Funeral flowers").build(),
                CategoryDto.builder().name("Wedding flowers").build()
        );

        Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
        Mockito.when(mapper.fromEntityToDto(categoryList.get(0))).thenReturn(categoryDtoList.get(0));
        Mockito.when(mapper.fromEntityToDto(categoryList.get(1))).thenReturn(categoryDtoList.get(1));

        List<CategoryDto> result = categoryService.getAllCategories();

        Assertions.assertEquals("Funeral flowers", result.get(0).getName());
        Assertions.assertEquals("Wedding flowers", result.get(1).getName());

        Mockito.verify(categoryRepository).findAll();
        Mockito.verify(mapper, times(2)).fromEntityToDto(any(Category.class));
    }

    @Test
    public void testGetCategoryById_whenFound() {
        Category category = Category.builder().id(1).name("Birthday").build();

        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.of(category));
        Category result = categoryService.getCategoryById(1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Birthday", result.getName());
    }

    @Test
    public void testGetCategoryById_whenNotFound() {
        Mockito.when(categoryRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(
                CategoryNotFoundException.class, () -> categoryService.getCategoryById(any())
        );
    }

    @Test
    public void testCreateCategory() {
        CategoryDto inputCategoryDto = CategoryDto.builder().name("Birthday").build();
        Category savedCategory = Category.builder().id(1).name("Birthday").build();
        CategoryDto categoryDto = CategoryDto.builder().id(1).name("Birthday").build();

        Mockito.when(categoryRepository.save(any())).thenReturn(savedCategory);
        Mockito.when(mapper.fromEntityToDto(savedCategory)).thenReturn(categoryDto);

        CategoryDto result = categoryService.createCategory(inputCategoryDto);

        Mockito.verify(mapper).fromEntityToDto(savedCategory);
        Assertions.assertEquals("Birthday", result.getName());
    }
}
