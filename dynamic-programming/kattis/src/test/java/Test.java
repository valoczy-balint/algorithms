import dp.kattis.Kattis;
import kotlin.Pair;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        Kattis kattis = new Kattis();

        Integer[] input1 = new Integer[]{529, 382, 130, 462, 223, 167, 235, 529};
        Integer[] input2 = new Integer[]{528, 129, 376, 504, 543, 363, 213, 138, 206, 440, 504, 418};

        Pair<Integer, Integer> result1 = measureTime(kattis::splitWeightEvenly, input1);
        System.out.println(result1.component1() + " " + result1.component2());

        Pair<Integer, Integer> result2 = measureTime(kattis::splitWeightEvenly, input2);
        System.out.println(result2.component1() + " " + result2.component2());
    }

    private Pair<Integer, Integer> measureTime(Function<Integer[], Pair<Integer, Integer>> function, Integer[] argument) {
        Instant start = Instant.now();
        Pair<Integer, Integer> result = function.apply(argument);
        Instant finish = Instant.now();
        System.out.println(Duration.between(start, finish).toMillis());
        return result;
    }
}
