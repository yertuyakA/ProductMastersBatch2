package kz.kop_flowers.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.kop_flowers.controller.CategoryController;
import kz.kop_flowers.model.dto.CategoryDto;
import kz.kop_flowers.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @TestConfiguration
    static class MockConfig {
        @Bean
        public CategoryService categoryService() {
            return Mockito.mock(CategoryService.class);
        }
    }

    @Autowired
    private CategoryService categoryService;

    @Test
    void testGetAllCategories() throws Exception {
        List<CategoryDto> categoryDtoList = List.of(
                CategoryDto.builder().id(1).name("Wedding").build(),
                CategoryDto.builder().id(2).name("Birthday").build()
        );

        Mockito.when(categoryService.getAllCategories()).thenReturn(categoryDtoList);

        mockMvc.perform(get("/api/category/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Wedding"));

        Mockito.verify(categoryService).getAllCategories();
    }

    @Test
    void testCreateCategory() throws Exception {
        CategoryDto requestDto = CategoryDto.builder()
                .name("Wedding")
                .build();

        CategoryDto responseDto = CategoryDto.builder()
                .id(1)
                .name("Wedding")
                .build();

        Mockito.when(categoryService.createCategory(Mockito.any())).thenReturn(responseDto);

        mockMvc.perform(post("/api/category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Wedding"));

        Mockito.verify(categoryService).createCategory(requestDto);
    }
}
