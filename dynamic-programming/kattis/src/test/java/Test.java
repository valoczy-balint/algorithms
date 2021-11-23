import dp.kattis.Kattis;
import kotlin.Pair;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        Kattis kattis = new Kattis();

        Integer[] input1 = new Integer[]{1, 3, 2, 4};

        Integer[] input2 = new Integer[]{529, 382, 130, 462, 223, 167, 235, 529};
        Integer[] input3 = new Integer[]{528, 129, 376, 504, 543, 363, 213, 138, 206, 440, 504, 418};

        Pair<Integer, Integer> recursiveResult1 = measureTime(kattis::splitWeightEvenly, input1);
        System.out.println(recursiveResult1.component1() + " " + recursiveResult1.component2());

        Pair<Integer, Integer> recursiveResult2 = measureTime(kattis::splitWeightEvenly, input2);
        System.out.println(recursiveResult2.component1() + " " + recursiveResult2.component2());

        Pair<Integer, Integer> recursiveResult3 = measureTime(kattis::splitWeightEvenlyDynamic, input3);
        System.out.println(recursiveResult3.component1() + " " + recursiveResult3.component2());
        
        Pair<Integer, Integer> dpResult1 = measureTime(kattis::splitWeightEvenlyDynamic, input1);
        System.out.println(dpResult1.component1() + " " + dpResult1.component2());

        Pair<Integer, Integer> dpResult2 = measureTime(kattis::splitWeightEvenlyDynamic, input2);
        System.out.println(dpResult2.component1() + " " + dpResult2.component2());

        Pair<Integer, Integer> dpResult3 = measureTime(kattis::splitWeightEvenlyDynamic, input3);
        System.out.println(dpResult3.component1() + " " + dpResult3.component2());
    }

    private Pair<Integer, Integer> measureTime(Function<Integer[], Pair<Integer, Integer>> function, Integer[] argument) {
        Instant start = Instant.now();
        Pair<Integer, Integer> result = function.apply(argument);
        Instant finish = Instant.now();
        System.out.println(Duration.between(start, finish).toMillis());
        return result;
    }
}
