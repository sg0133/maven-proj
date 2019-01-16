package ken.kata.techtest.validator;

import java.util.function.Predicate;

public class Precondition {
    private Predicate<Integer> unitsPredicate;
    private String message;

    public Precondition(Predicate<Integer> unitsPredicate, String message) {
        this.unitsPredicate = unitsPredicate;
        this.message = message;
    }

    public void validate(int units) {
        if (!unitsPredicate.test(units)) {
            throw new IllegalArgumentException(message);
        }
    }
}
