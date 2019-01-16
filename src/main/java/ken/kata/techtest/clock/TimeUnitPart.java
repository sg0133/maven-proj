package ken.kata.techtest.clock;

import ken.kata.techtest.view.Lamp;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;

public class TimeUnitPart implements TimeUnit {
    public static final String LAMPS_DELIMITER = "";

    protected final List<Lamp> lamps;
    protected final LampsOnFunction lampsOnFunction;

    public TimeUnitPart(List<Lamp> lamps, LampsOnFunction lampsOnFunction) {
        this.lamps = lamps;
        this.lampsOnFunction = lampsOnFunction;
    }

    /**
     * This method is thread safe
     */
    public String display(int units) {
        ArrayList<Lamp> lampsClone = clonedLamps();

        range(0, lampsOnFunction.calculateLampsOnFor(units)).
                forEach((index) -> lampsClone.get(index).switchOn());

        return lampsClone.stream().
                map(lamp -> lamp.toString()).
                collect(joining(LAMPS_DELIMITER));
    }

    /**
     * Make sure we don't work with internal lamps, copy lamps, so both concurrent threads
     * and consequent calls by single thread works with a local copy
     */
    private ArrayList<Lamp> clonedLamps() {
        ArrayList<Lamp> lampsCopy = new ArrayList<>(lamps.size());
        lamps.forEach((lamp) -> lampsCopy.add(lamp.copy()));
        return lampsCopy;
    }
}