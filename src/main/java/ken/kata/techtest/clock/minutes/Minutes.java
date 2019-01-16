package ken.kata.techtest.clock.minutes;

import ken.kata.techtest.clock.AbstractTimeUnit;
import ken.kata.techtest.clock.TimeUnit;
import ken.kata.techtest.validator.Precondition;

public class Minutes extends AbstractTimeUnit implements TimeUnit {
    public Minutes() {
        timeUnitParts = MinutesFactory.createParts();
        precondition = new Precondition(
                (units) -> units >= 0 && units <= 59,
                "Minute units must be in range: units >= 0 && units <= 59");
    }
}
