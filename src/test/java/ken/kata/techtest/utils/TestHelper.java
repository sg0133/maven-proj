package ken.kata.techtest.utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestHelper {
    public static final Tuple2[] TEST_CASE_POOL = new Tuple2[]{
            new Tuple2("13::17:01", "O RROO RRRO YYROOOOOOOO YYOO"),
            new Tuple2("23::59:59", "O RRRR RRRO YYRYYRYYRYY YYYY"),
            new Tuple2("24::00:00", "Y RRRR RRRR OOOOOOOOOOO OOOO"),
            new Tuple2("24::00:01", "O RRRR RRRR OOOOOOOOOOO OOOO"),
            new Tuple2("01::00:00", "Y OOOO ROOO OOOOOOOOOOO OOOO"),
            new Tuple2("10::10:10", "Y RROO OOOO YYOOOOOOOOO OOOO"),
            new Tuple2("16::16:16", "Y RRRO ROOO YYROOOOOOOO YOOO"),
    };

    public static class Tuple2 {
        public final String first;
        public final String second;

        public Tuple2(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    public static String getSecond(Future<Tuple2> testCaseFuture) {
        try {
            return testCaseFuture.get().second;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFirst(Future<Tuple2> testCaseFuture) {
        try {
            return testCaseFuture.get().first;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
