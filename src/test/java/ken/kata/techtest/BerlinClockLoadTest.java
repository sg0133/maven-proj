package ken.kata.techtest;

import ken.kata.techtest.parser.BerlinClockParser;
import ken.kata.techtest.utils.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.stream.IntStream.range;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * This class tests berlinClock.displayTime method under concurrent load.
 * It creates 100 threads, waits until all threads are submitted,
 * then runs them concurrently and saves expectedOutput and actualOutput
 * in a tuple. Once all threads has finished, it then asserts that all
 * result are correct by going through the list returned by each thread.
 */
public class BerlinClockLoadTest {

    public static final int THREAD_SIZE = 100;

    BerlinClock berlinClock;
    Random random = new Random();

    @Before
    public void setUp() {
        berlinClock = new BerlinClockImpl(new BerlinClockParser("(\\d{2})::(\\d{2}):(\\d{2})"));
    }

    @Test
    public void loadTest() throws InterruptedException, ExecutionException {
        //synchronise threads
        CountDownLatch allDone = new CountDownLatch(THREAD_SIZE);
        CountDownLatch allPrepared = new CountDownLatch(THREAD_SIZE);

        ExecutorService executor = newFixedThreadPool(THREAD_SIZE);
        List<Future<TestHelper.Tuple2>> testCaseFutures = new ArrayList<>();

        range(0, THREAD_SIZE).forEach((i) -> {
            Future<TestHelper.Tuple2> testCaseFuture = executor.submit(() -> {
                //wait for all before start
                allPrepared.await();

                int randomIndex = random.nextInt(TestHelper.TEST_CASE_POOL.length);
                TestHelper.Tuple2 testCase = TestHelper.TEST_CASE_POOL[randomIndex];
                String input = testCase.first;
                String expectedOutput = testCase.second;

                String actualOutput = berlinClock.displayTime(input);
                allDone.countDown();
                return new TestHelper.Tuple2(expectedOutput, actualOutput);
            });
            testCaseFutures.add(testCaseFuture);
            allPrepared.countDown();
        });

        //wait before all done
        allDone.await();

        //test
        testCaseFutures.forEach((testCaseFuture) -> {
            String expected = TestHelper.getFirst(testCaseFuture);
            String actual = TestHelper.getSecond(testCaseFuture);

            assertThat(actual).isEqualTo(expected);
        });
    }
}
