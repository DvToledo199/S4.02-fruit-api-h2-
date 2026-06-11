package cat.itacademy.s04.t02.n01.fruit.services;

import cat.itacademy.s04.t02.n01.fruit.models.dto.FruitRequestDTO;
import cat.itacademy.s04.t02.n01.fruit.models.dto.FruitResponseDTO;

import java.util.List;

public interface FruitService {

    FruitResponseDTO createFruit(FruitRequestDTO requestDTO);

    List<FruitResponseDTO> getAllFruits();

    FruitResponseDTO getFruitById(Long id);

    FruitResponseDTO updateFruit(Long id, FruitRequestDTO requestDTO);

    void deleteFruit(Long id);


}
