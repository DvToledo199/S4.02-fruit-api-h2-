package cat.itacademy.s04.t02.n01.fruit.exceptions;

public class FruitNotFoundException extends RuntimeException {

    public FruitNotFoundException() {
        super("Fruit not found");
    }
}
