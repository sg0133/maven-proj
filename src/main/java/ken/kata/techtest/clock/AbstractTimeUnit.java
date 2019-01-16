package ken.kata.techtest.clock;

import ken.kata.techtest.validator.Precondition;

import java.util.List;

import static java.util.stream.Collectors.joining;

public abstract class AbstractTimeUnit implements TimeUnit {
    public static final String TIME_UNITS_PART_DELIMITER = " ";

    protected List<? extends TimeUnit> timeUnitParts;
    protected Precondition precondition;

    @Override
    public String display(int units) {
        precondition.validate(units);

        return timeUnitParts.stream().
                map(timeUnitPart -> timeUnitPart.display(units)).
                collect(joining(TIME_UNITS_PART_DELIMITER));
    }
}
