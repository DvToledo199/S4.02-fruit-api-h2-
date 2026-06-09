package cat.itacademy.s04.t02.n01.fruit.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class FruitResponseDTO {
    private Long id;
    private String name;
    private int weightInKilos;

}
