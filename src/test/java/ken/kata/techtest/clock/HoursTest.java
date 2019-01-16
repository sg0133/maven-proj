package ken.kata.techtest.clock;

import ken.kata.techtest.clock.hours.Hours;
import ken.kata.techtest.utils.Exceptions;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class HoursTest {

    AbstractTimeUnit hours;

    @Before
    public void setUp() {
        hours = new Hours();
    }

    @Test
    public void ten() {
        System.out.println(hours.display(10));
    }

    @Test
    public void allHoursOn() {
        assertThat(hours.display(24)).isEqualTo("RRRR RRRR");
    }

    @Test
    public void last4HoursOn() {
        assertThat(hours.display(04)).isEqualTo("OOOO RRRR");
    }

    @Test
    public void last1AndFirst1HoursOn() {
        assertThat(hours.display(6)).isEqualTo("ROOO ROOO");
    }

    @Test
    public void hoursIllegal() {
        Exceptions.assertThat(() ->
                hours.display(25))
                .throwsException(IllegalArgumentException.class)
                .withMessageContaining("Hour");
    }
}
