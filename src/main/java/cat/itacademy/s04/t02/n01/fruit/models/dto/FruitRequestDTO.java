package cat.itacademy.s04.t02.n01.fruit.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FruitRequestDTO {
    @NotBlank
    private String name;
    @Positive
    private int weightInKilos;
}
