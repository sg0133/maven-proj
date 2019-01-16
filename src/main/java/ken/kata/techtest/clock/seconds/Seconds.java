package ken.kata.techtest.clock.seconds;

import ken.kata.techtest.clock.AbstractTimeUnit;
import ken.kata.techtest.clock.TimeUnit;
import ken.kata.techtest.validator.Precondition;

public class Seconds extends AbstractTimeUnit implements TimeUnit {
    public Seconds() {
        timeUnitParts = SecondsFactory.createParts();
        precondition = new Precondition(
                (units) -> units >= 0 && units <= 59,
                "Second units must be in range: units >= 0 && units <= 59");
    }
}
