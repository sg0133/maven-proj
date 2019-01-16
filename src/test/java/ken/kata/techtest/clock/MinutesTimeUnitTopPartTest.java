package ken.kata.techtest.clock;

import ken.kata.techtest.clock.minutes.MinutesFactory;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class MinutesTimeUnitTopPartTest {

    TimeUnitPart timeUnitPart;

    @Before
    public void setUp() {
        timeUnitPart = MinutesFactory.createTopPart();
    }

    @Test
    public void testWhen3FirstOn() {
        int minutes = 16;

        assertThat(timeUnitPart.lampsOnFunction.calculateLampsOnFor(minutes)).isEqualTo(3);
        assertThat(timeUnitPart.display(minutes)).isEqualTo("YYROOOOOOOO");
    }

    @Test
    public void testWhenAllOn() {
        int minutes = 56;

        assertThat(timeUnitPart.lampsOnFunction.calculateLampsOnFor(minutes)).isEqualTo(11);
        assertThat(timeUnitPart.display(minutes)).isEqualTo("YYRYYRYYRYY");
    }

    @Test
    public void testWhenOffWitNonZero() {
        int minutes = 4;

        assertThat(timeUnitPart.lampsOnFunction.calculateLampsOnFor(minutes)).isEqualTo(0);
        assertThat(timeUnitPart.display(minutes)).isEqualTo("OOOOOOOOOOO");
    }

    @Test
    public void testWhenOffWithZero() {
        int minutes = 0;

        assertThat(timeUnitPart.lampsOnFunction.calculateLampsOnFor(minutes)).isEqualTo(0);
        assertThat(timeUnitPart.display(minutes)).isEqualTo("OOOOOOOOOOO");
    }
}
