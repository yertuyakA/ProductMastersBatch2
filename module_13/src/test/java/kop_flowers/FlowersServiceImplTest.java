package kop_flowers;

import kz.kop_flowers.model.FlowerMapper;
import kz.kop_flowers.model.dto.CategoryDto;
import kz.kop_flowers.model.dto.FlowerDto;
import kz.kop_flowers.model.entity.Category;
import kz.kop_flowers.model.entity.Flower;
import kz.kop_flowers.model.exception.FlowerNotFoundException;
import kz.kop_flowers.repository.FlowerRepository;
import kz.kop_flowers.service.CategoryService;
import kz.kop_flowers.service.FlowerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class FlowersServiceImplTest {

    @Mock
    private FlowerRepository flowerRepository;
    @Mock
    private FlowerMapper mapper;
    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private FlowerServiceImpl flowerService;

    @Test
    public void testGetAllFlowers() {
        List<Flower> flowers = List.of(
                Flower.builder().id(1).name("Роза").build(),
                Flower.builder().id(2).name("Пионы").build()
        );

        List<FlowerDto> flowerDtoList = List.of(
                FlowerDto.builder().id(1).name("Роза").build(),
                FlowerDto.builder().id(2).name("Пионы").build()
        );

        Mockito.when(flowerRepository.findAll()).thenReturn(flowers);
        Mockito.when(mapper.fromEntityToDto(flowers.get(0))).thenReturn(flowerDtoList.get(0));
        Mockito.when(mapper.fromEntityToDto(flowers.get(1))).thenReturn(flowerDtoList.get(1));
        //
        //
        List<FlowerDto> result = flowerService.getAllFlowers();
        //
        //
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Роза", result.get(0).getName());
    }

    @Test
    public void testGetFlowerById_whenNotExists() {
        Mockito.when(flowerRepository.findById(any())).thenReturn(Optional.empty());
        Assertions.assertThrows(FlowerNotFoundException.class, () -> flowerService.getFlowerById(any()));
    }

    @Test
    public void testCreateFlower() {
        Category category = Category.builder().id(1).name("8 марта").build();

        FlowerDto inputFlowerDto = FlowerDto.builder()
                .name("Роза")
                .price(BigDecimal.valueOf(100))
                .size("M")
                .category(CategoryDto.builder().id(1).build())
                .build();
        Flower savedFlower = Flower.builder()
                .id(1)
                .name("Роза")
                .price(BigDecimal.valueOf(100))
                .size("M")
                .category(category)
                .build();
        FlowerDto flowerDto = FlowerDto.builder()
                .id(1)
                .name("Роза")
                .price(BigDecimal.valueOf(100))
                .size("M")
                .category(CategoryDto.builder().id(1).build())
                .build();

        Mockito.when(categoryService.getCategoryById(1)).thenReturn(category);
        Mockito.when(flowerRepository.save(any(Flower.class))).thenReturn(savedFlower);
        Mockito.when(mapper.fromEntityToDto(savedFlower)).thenReturn(flowerDto);
        //
        //
        FlowerDto result = flowerService.createFlower(inputFlowerDto);
        //
        //
        Assertions.assertEquals("Пионы", result.getName());
        Assertions.assertEquals(1, result.getCategory().getId());
    }

}
