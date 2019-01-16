package ken.kata.techtest;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import ken.kata.techtest.parser.BerlinClockParser;
import ken.kata.techtest.utils.Exceptions;
import ken.kata.techtest.utils.TestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
/**
 * Parameterized test that loads test cases from TEST_CASE_POOL
 */
public class BerlinClockUTest {
    BerlinClock berlinClock;

    @Before
    public void setUp() {
        berlinClock = new BerlinClockImpl(new BerlinClockParser("(\\d{2})::(\\d{2}):(\\d{2})"));
    }

    @Test
    public void nullTest() {
        Exceptions.assertThat(() -> berlinClock.displayTime(null)).
                throwsException(IllegalArgumentException.class).
                withMessageContaining("Input");
    }

    @Parameters
    TestHelper.Tuple2[] dataProvider() {
        return TestHelper.TEST_CASE_POOL;
    }

    @Test
    @Parameters(method = "dataProvider")
    public void testDisplayTime(TestHelper.Tuple2 testCase) {
        String input = testCase.first;
        String expected = testCase.second;

       String actual = berlinClock.displayTime(input);
//         String actual = "wrong";        
        System.out.println(input + " -> " + actual);

        assertThat(actual).overridingErrorMessage("for input: " + input +
                " expected output was: " + expected +
                " but got: " + actual).
                isEqualTo(expected);
    }
}
