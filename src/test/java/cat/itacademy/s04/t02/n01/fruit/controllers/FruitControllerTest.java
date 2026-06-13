package cat.itacademy.s04.t02.n01.fruit.controllers;

import cat.itacademy.s04.t02.n01.fruit.models.dto.FruitResponseDTO;
import cat.itacademy.s04.t02.n01.fruit.models.dto.FruitRequestDTO;
import cat.itacademy.s04.t02.n01.fruit.services.FruitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FruitController.class)
class FruitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FruitService fruitService;

    @Test
    void getAllFruits_ShouldReturnListOfFruits() throws Exception {

        FruitResponseDTO fruit1 = new FruitResponseDTO(1L, "Apple", 10);
        FruitResponseDTO fruit2 = new FruitResponseDTO(2L, "Banana", 5);

        when(fruitService.getAllFruits())
                .thenReturn(List.of(fruit1, fruit2));

        mockMvc.perform(get("/fruits")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Apple"))
                .andExpect(jsonPath("$[0].weightInKilos").value(10))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Banana"))
                .andExpect(jsonPath("$[1].weightInKilos").value(5));
    }

    @Test
    void getFruitById_ShouldReturnFruit() throws Exception {

        FruitResponseDTO fruit = new FruitResponseDTO(1L, "Apple", 10);

        when(fruitService.getFruitById(1L)).thenReturn(fruit);

        mockMvc.perform(get("/fruits/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Apple"))
                .andExpect(jsonPath("$.weightInKilos").value(10));
    }
    @Test
    void createFruit_ShouldReturnCreatedFruit() throws Exception {

        FruitResponseDTO fruit = new FruitResponseDTO(1L, "Apple", 10);

        when(fruitService.createFruit(org.mockito.ArgumentMatchers.any(FruitRequestDTO.class)))
                .thenReturn(fruit);

        mockMvc.perform(post("/fruits")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  \"name\": \"Apple\",
                                  \"weightInKilos\": 10
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Apple"))
                .andExpect(jsonPath("$.weightInKilos").value(10));
    }

    @Test
    void updateFruit_ShouldReturnUpdatedFruit() throws Exception {

        FruitResponseDTO fruit = new FruitResponseDTO(1L, "Orange", 15);

        when(fruitService.updateFruit(
                org.mockito.ArgumentMatchers.eq(1L),
                org.mockito.ArgumentMatchers.any(FruitRequestDTO.class)))
                .thenReturn(fruit);

        mockMvc.perform(put("/fruits/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  \"name\": \"Orange\",
                                  \"weightInKilos\": 15
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Orange"))
                .andExpect(jsonPath("$.weightInKilos").value(15));
    }

    @Test
    void deleteFruit_ShouldReturnNoContent() throws Exception {

        mockMvc.perform(delete("/fruits/1"))
                .andExpect(status().isNoContent());
    }
}
