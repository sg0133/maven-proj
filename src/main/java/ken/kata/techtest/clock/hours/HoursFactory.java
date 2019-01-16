package ken.kata.techtest.clock.hours;

import ken.kata.techtest.clock.TimeUnit;
import ken.kata.techtest.clock.TimeUnitPart;
import ken.kata.techtest.view.Color;
import ken.kata.techtest.view.Lamp;

import java.util.List;

import static java.util.Arrays.asList;

public class HoursFactory {
    public static List<? extends TimeUnit> createParts() {
        return asList(
                createTopPart(),
                createBottomPart());
    }

    public static TimeUnitPart createTopPart() {
        return new TimeUnitPart(
                asList(new Lamp(Color.RED),
                        new Lamp(Color.RED),
                        new Lamp(Color.RED),
                        new Lamp(Color.RED)),
                (units) -> units / 5);
    }

    public static TimeUnitPart createBottomPart() {
        return new TimeUnitPart(
                asList(new Lamp(Color.RED),
                        new Lamp(Color.RED),
                        new Lamp(Color.RED),
                        new Lamp(Color.RED)),
                (units) -> units % 5);
    }
}
