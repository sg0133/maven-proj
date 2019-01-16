package ken.kata.techtest.clock;

import ken.kata.techtest.clock.seconds.SecondsFactory;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class SecondsTimeUnitPartTest {

    TimeUnitPart timeUnitPart;

    @Before
    public void setUp() {
        timeUnitPart = SecondsFactory.createPart();
    }

    @Test
    public void testWhenSwitchedOn() {
        int seconds = 0;

        assertThat(timeUnitPart.lampsOnFunction.calculateLampsOnFor(seconds)).isEqualTo(1);
        assertThat(timeUnitPart.display(seconds)).isEqualTo("Y");
    }

    @Test
    public void testWhenSwitchedOff() {
        int seconds = 21;

        assertThat(timeUnitPart.lampsOnFunction.calculateLampsOnFor(seconds)).isEqualTo(0);
        assertThat(timeUnitPart.display(seconds)).isEqualTo("O");
    }
}
