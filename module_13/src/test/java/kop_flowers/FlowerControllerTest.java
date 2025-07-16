package kop_flowers;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.kop_flowers.controller.FlowerController;
import kz.kop_flowers.model.dto.CategoryDto;
import kz.kop_flowers.model.dto.FlowerDto;
import kz.kop_flowers.service.FlowerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(FlowerController.class)
class FlowerControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private FlowerService flowerService;

    private FlowerService flowerService;

    @BeforeEach
    void setUp() {
        flowerService = Mockito.mock(FlowerService.class);
    }


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllFlowers() throws Exception {
        List<FlowerDto> flowers = List.of(
                FlowerDto.builder().id(1).name("Rose").build(),
                FlowerDto.builder().id(2).name("Tulip").build()
        );

        Mockito.when(flowerService.getAllFlowers()).thenReturn(flowers);

        mockMvc.perform(get("/api/flowers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Rose"));
    }

    @Test
    void testGetFlowerById() throws Exception {
        FlowerDto flower = FlowerDto.builder().id(1).name("Orchid").build();

        Mockito.when(flowerService.getFlowerById(1)).thenReturn(flower);

        mockMvc.perform(get("/api/flowers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Orchid"));
    }

    @Test
    void testCreateFlower() throws Exception {
        FlowerDto requestDto = FlowerDto.builder()
                .name("Peony")
                .price(BigDecimal.valueOf(5000))
                .size("M")
                .category(CategoryDto.builder().id(10).name("8 марта").build())
                .build();

        FlowerDto responseDto = FlowerDto.builder()
                .id(1)
                .name("Peony")
                .price(BigDecimal.valueOf(5000))
                .size("M")
                .category(CategoryDto.builder().id(10).name("Birthday").build())
                .build();

        Mockito.when(flowerService.createFlower(Mockito.any())).thenReturn(responseDto);

        mockMvc.perform(post("/api/flowers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Peony"))
                .andExpect(jsonPath("$.category.name").value("Birthday"));
    }
}