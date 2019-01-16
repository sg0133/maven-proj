package ken.kata.techtest.clock;

import ken.kata.techtest.clock.seconds.Seconds;
import ken.kata.techtest.utils.Exceptions;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class SecondsTest {

    AbstractTimeUnit seconds;

    @Before
    public void setUp() {
        seconds = new Seconds();
    }

    @Test
    public void secondsOn() {
        assertThat(seconds.display(20)).isEqualTo("Y");
    }

    @Test
    public void secondsOff() {
        assertThat(seconds.display(21)).isEqualTo("O");
    }

    @Test
    public void secondsIllegal() {
        Exceptions.assertThat(() ->
                seconds.display(666))
                .throwsException(IllegalArgumentException.class)
                .withMessageContaining("Second");
    }
}
