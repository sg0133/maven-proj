package ken.kata.techtest.clock;

import ken.kata.techtest.clock.minutes.Minutes;
import ken.kata.techtest.utils.Exceptions;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class MinutesTest {

    AbstractTimeUnit minutes;

    @Before
    public void setUp() {
        minutes = new Minutes();
    }

    @Test
    public void allMinutesOn() {
        assertThat(minutes.display(59)).isEqualTo("YYRYYRYYRYY YYYY");
    }

    @Test
    public void bottomOn() {
        assertThat(minutes.display(04)).isEqualTo("OOOOOOOOOOO YYYY");
    }

    @Test
    public void TopFirst1AndBottomFirst1On() {
        assertThat(minutes.display(16)).isEqualTo("YYROOOOOOOO YOOO");
    }

    @Test
    public void dfs() {
        assertThat(minutes.display(16)).isEqualTo("YYROOOOOOOO YOOO");
    }

    @Test
    public void minutesIllegal() {
        Exceptions.assertThat(() ->
                minutes.display(60))
                .throwsException(IllegalArgumentException.class)
                .withMessageContaining("Minute");
    }
}
