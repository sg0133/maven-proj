package ken.kata.techtest.clock.hours;

import ken.kata.techtest.clock.AbstractTimeUnit;
import ken.kata.techtest.clock.TimeUnit;
import ken.kata.techtest.validator.Precondition;

public class Hours extends AbstractTimeUnit implements TimeUnit {
    public Hours() {
        timeUnitParts = HoursFactory.createParts();
        precondition = new Precondition(
                (units) -> units >= 1 && units <= 24,
                "Hour units must be in range: units >= 1 && units <= 24");
    }
}
