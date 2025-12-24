import java.util.Random;

public class RandomCoordinate extends Coordinate {

    private static final Random random = new Random();

    public RandomCoordinate(){
        super(random.nextInt(-100, 100), random.nextInt(-100, 100));
    }
}
