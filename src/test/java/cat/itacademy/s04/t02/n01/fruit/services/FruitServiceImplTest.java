package cat.itacademy.s04.t02.n01.fruit.services;

import cat.itacademy.s04.t02.n01.fruit.exceptions.FruitNotFoundException;
import cat.itacademy.s04.t02.n01.fruit.models.dto.FruitRequestDTO;
import cat.itacademy.s04.t02.n01.fruit.models.dto.FruitResponseDTO;
import cat.itacademy.s04.t02.n01.fruit.models.entity.Fruit;
import cat.itacademy.s04.t02.n01.fruit.repositories.FruitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FruitServiceImplTest {

    @Mock
    private FruitRepository fruitRepository;

    @InjectMocks
    private FruitServiceImpl fruitService;

    @Test
    void createFruit_ShouldReturnFruitResponseDTO_WhenFruitIsCreated() {

        FruitRequestDTO requestDTO = new FruitRequestDTO("Apple", 10);

        Fruit savedFruit = new Fruit();
        savedFruit.setId(1L);
        savedFruit.setName("Apple");
        savedFruit.setWeightInKilos(10);

        when(fruitRepository.save(any(Fruit.class))).thenReturn(savedFruit);

        FruitResponseDTO result = fruitService.createFruit(requestDTO);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Apple", result.getName());
        assertEquals(10, result.getWeightInKilos());
    }

    @Test
    void getFruitById_ShouldReturnFruitResponseDTO_WhenFruitExists() {

        Fruit fruit = new Fruit();
        fruit.setId(1L);
        fruit.setName("Banana");
        fruit.setWeightInKilos(5);

        when(fruitRepository.findById(1L)).thenReturn(Optional.of(fruit));

        FruitResponseDTO result = fruitService.getFruitById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Banana", result.getName());
        assertEquals(5, result.getWeightInKilos());
    }

    @Test
    void getFruitById_ShouldThrowException_WhenFruitDoesNotExist() {

        when(fruitRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(FruitNotFoundException.class,
                () -> fruitService.getFruitById(99L));
    }

    @Test
    void updateFruit_ShouldReturnUpdatedFruitResponseDTO_WhenFruitExists() {

        FruitRequestDTO requestDTO = new FruitRequestDTO("Orange", 15);

        Fruit fruit = new Fruit();
        fruit.setId(1L);
        fruit.setName("Apple");
        fruit.setWeightInKilos(10);

        Fruit updatedFruit = new Fruit();
        updatedFruit.setId(1L);
        updatedFruit.setName("Orange");
        updatedFruit.setWeightInKilos(15);

        when(fruitRepository.findById(1L)).thenReturn(Optional.of(fruit));
        when(fruitRepository.save(any(Fruit.class))).thenReturn(updatedFruit);

        FruitResponseDTO result = fruitService.updateFruit(1L, requestDTO);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Orange", result.getName());
        assertEquals(15, result.getWeightInKilos());
    }

    @Test
    void deleteFruit_ShouldDeleteFruit_WhenFruitExists() {

        Fruit fruit = new Fruit();
        fruit.setId(1L);
        fruit.setName("Apple");
        fruit.setWeightInKilos(10);

        when(fruitRepository.findById(1L)).thenReturn(Optional.of(fruit));

        assertDoesNotThrow(() -> fruitService.deleteFruit(1L));
    }
}
