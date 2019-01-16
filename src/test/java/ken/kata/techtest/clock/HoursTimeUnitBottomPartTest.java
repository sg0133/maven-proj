package ken.kata.techtest.clock;

import ken.kata.techtest.clock.hours.HoursFactory;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class HoursTimeUnitBottomPartTest {

    TimeUnitPart timeUnitPart;

    @Before
    public void setUp() {
        timeUnitPart = HoursFactory.createBottomPart();
    }

    @Test
    public void testWhen2FirstOn() {
        int hours = 12;

        assertThat(timeUnitPart.lampsOnFunction.calculateLampsOnFor(hours)).isEqualTo(2);
        assertThat(timeUnitPart.display(hours)).isEqualTo("RROO");
    }

    @Test
    public void testWhenAllOn() {
        int hours = 24;

        assertThat(timeUnitPart.lampsOnFunction.calculateLampsOnFor(hours)).isEqualTo(4);
        assertThat(timeUnitPart.display(hours)).isEqualTo("RRRR");
    }

    @Test
    public void testWhenOff() {
        int hours = 10;

        assertThat(timeUnitPart.lampsOnFunction.calculateLampsOnFor(hours)).isEqualTo(0);
        assertThat(timeUnitPart.display(hours)).isEqualTo("OOOO");
    }
}
