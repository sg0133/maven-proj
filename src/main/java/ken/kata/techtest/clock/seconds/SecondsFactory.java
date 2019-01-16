package ken.kata.techtest.clock.seconds;

import ken.kata.techtest.clock.TimeUnit;
import ken.kata.techtest.clock.TimeUnitPart;
import ken.kata.techtest.view.Color;
import ken.kata.techtest.view.Lamp;

import java.util.List;

import static java.lang.Math.abs;
import static java.util.Arrays.asList;

public class SecondsFactory {
    public static List<? extends TimeUnit> createParts() {
        return asList(createPart());
    }

    public static TimeUnitPart createPart() {
        return new TimeUnitPart(
                asList(new Lamp(Color.YELLOW)),
                (units) -> abs((units % 2) - 1));
    }
}
