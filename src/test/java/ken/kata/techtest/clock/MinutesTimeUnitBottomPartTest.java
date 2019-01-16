package ken.kata.techtest.clock;

import ken.kata.techtest.clock.minutes.MinutesFactory;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class MinutesTimeUnitBottomPartTest {

    TimeUnitPart timeUnitPart;

    @Before
    public void setUp() {
        timeUnitPart = MinutesFactory.createBottomPart();
    }

    @Test
    public void testWhen2FirstOn() {
        int minutes = 12;

        assertThat(timeUnitPart.lampsOnFunction.calculateLampsOnFor(minutes)).isEqualTo(2);
        assertThat(timeUnitPart.display(minutes)).isEqualTo("YYOO");
    }

    @Test
    public void testWhenAllOn() {
        int minutes = 24;

        assertThat(timeUnitPart.lampsOnFunction.calculateLampsOnFor(minutes)).isEqualTo(4);
        assertThat(timeUnitPart.display(minutes)).isEqualTo("YYYY");
    }

    @Test
    public void testWhenOffWithZero() {
        int minutes = 0;

        assertThat(timeUnitPart.lampsOnFunction.calculateLampsOnFor(minutes)).isEqualTo(0);
        assertThat(timeUnitPart.display(minutes)).isEqualTo("OOOO");
    }

    @Test
    public void testWhenOffWithNonZero() {
        int minutes = 10;

        assertThat(timeUnitPart.lampsOnFunction.calculateLampsOnFor(minutes)).isEqualTo(0);
        assertThat(timeUnitPart.display(minutes)).isEqualTo("OOOO");
    }
}
