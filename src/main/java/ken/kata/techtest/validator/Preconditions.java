package ken.kata.techtest.validator;

public class Preconditions {
    public static void validate(boolean condition, String message) {
        if (!condition) throw new IllegalArgumentException(message);
    }
}
