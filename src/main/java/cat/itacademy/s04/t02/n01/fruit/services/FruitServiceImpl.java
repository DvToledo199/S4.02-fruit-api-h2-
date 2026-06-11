package cat.itacademy.s04.t02.n01.fruit.services;

import cat.itacademy.s04.t02.n01.fruit.models.dto.FruitRequestDTO;
import cat.itacademy.s04.t02.n01.fruit.models.dto.FruitResponseDTO;
import cat.itacademy.s04.t02.n01.fruit.repositories.FruitRepository;
import org.springframework.stereotype.Service;
import cat.itacademy.s04.t02.n01.fruit.models.entity.Fruit;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }


    @Override
    public FruitResponseDTO createFruit(FruitRequestDTO requestDTO) {
        Fruit fruit = new Fruit();
        fruit.setName(requestDTO.getName());
        fruit.setWeightInKilos(requestDTO.getWeightInKilos());

        Fruit savedFruit = fruitRepository.save(fruit);
        FruitResponseDTO fruitResponse = new FruitResponseDTO(
                savedFruit.getId(),
                savedFruit.getName(),
                savedFruit.getWeightInKilos()
        );
        return fruitResponse;
    }

    @Override
    public List<FruitResponseDTO> getAllFruits() {

        List<Fruit> fruitList = fruitRepository.findAll();

        return fruitList.stream()
                .map(fruit -> new FruitResponseDTO(
                        fruit.getId(),
                        fruit.getName(),
                        fruit.getWeightInKilos()
                ))
                .toList();
    }


@Override
public FruitResponseDTO getFruitById(Long id) {
    return null;
}

@Override
public FruitResponseDTO updateFruit(Long id, FruitRequestDTO requestDTO) {
    return null;
}

@Override
public void deleteFruit(Long id) {

}
}
