package cat.itacademy.s04.t02.n01.fruit.controllers;

import cat.itacademy.s04.t02.n01.fruit.models.dto.FruitRequestDTO;
import cat.itacademy.s04.t02.n01.fruit.services.FruitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import cat.itacademy.s04.t02.n01.fruit.models.dto.FruitResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/fruits")
@RequiredArgsConstructor
public class FruitController {

    private final FruitService fruitService;

    @PostMapping
    public FruitResponseDTO createFruit(
            @Valid @RequestBody FruitRequestDTO requestDTO) {
        return fruitService.createFruit(requestDTO);
    }

    @GetMapping
    public List<FruitResponseDTO> getAllFruits() {
        return fruitService.getAllFruits();
    }

    @GetMapping("/{id}")
    public FruitResponseDTO getFruitById(@PathVariable Long id) {
        return fruitService.getFruitById(id);
    }

    @PutMapping("/{id}")
    public FruitResponseDTO updateFruit(@PathVariable Long id, @Valid @RequestBody FruitRequestDTO requestDTO) {
        return fruitService.updateFruit(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFruit(@PathVariable Long id) {
        fruitService.deleteFruit(id);
    }


}
