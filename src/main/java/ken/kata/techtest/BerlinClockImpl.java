package ken.kata.techtest;

import ken.kata.techtest.clock.hours.Hours;
import ken.kata.techtest.clock.minutes.Minutes;
import ken.kata.techtest.clock.seconds.Seconds;
import ken.kata.techtest.parser.Parser;
import ken.kata.techtest.validator.Preconditions;

public class BerlinClockImpl implements BerlinClock {

    public static final String TIME_UNIT_DELIMITER = " ";
    public static final int MAX_SIZE = 28;
    private Parser parser;

    private Hours hours = new Hours();
    private Minutes minutes = new Minutes();
    private Seconds seconds = new Seconds();

    public BerlinClockImpl(Parser parser) {
        this.parser = parser;
    }

    @Override
    public String displayTime(String input) {
        Preconditions.validate(input != null, "Input string is null");

        Time time = parser.parse(input);

        return new StringBuilder(MAX_SIZE).
                append(seconds.display(time.seconds)).append(TIME_UNIT_DELIMITER).
                append(hours.display(time.hours)).append(TIME_UNIT_DELIMITER).
                append(minutes.display(time.minutes)).toString();
    }
}
