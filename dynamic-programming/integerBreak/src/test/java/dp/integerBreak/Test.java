package dp.integerBreak;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        Breaker breaker = new Breaker();

        System.out.println("Recursive");

        assertEquals(54, measureTime(breaker::breakIntegerRecursive, 11));
        assertEquals(81, measureTime(breaker::breakIntegerRecursive, 12));
        assertEquals(108, measureTime(breaker::breakIntegerRecursive, 13));
        assertEquals(162, measureTime(breaker::breakIntegerRecursive, 14));
        assertEquals(243, measureTime(breaker::breakIntegerRecursive, 15));
        assertEquals(324, measureTime(breaker::breakIntegerRecursive, 16));
        assertEquals(486, measureTime(breaker::breakIntegerRecursive, 17));
        assertEquals(729, measureTime(breaker::breakIntegerRecursive, 18));
        assertEquals(729, measureTime(breaker::breakIntegerRecursive, 18));
        assertEquals(972, measureTime(breaker::breakIntegerRecursive, 19));
        assertEquals(1458, measureTime(breaker::breakIntegerRecursive, 20));

        System.out.println("Cache");

        assertEquals(54, measureTime(breaker::breakIntegerRecursiveWithCache, 11));
        assertEquals(81, measureTime(breaker::breakIntegerRecursiveWithCache, 12));
        assertEquals(108, measureTime(breaker::breakIntegerRecursiveWithCache, 13));
        assertEquals(162, measureTime(breaker::breakIntegerRecursiveWithCache, 14));
        assertEquals(243, measureTime(breaker::breakIntegerRecursiveWithCache, 15));
        assertEquals(324, measureTime(breaker::breakIntegerRecursiveWithCache, 16));
        assertEquals(486, measureTime(breaker::breakIntegerRecursiveWithCache, 17));
        assertEquals(729, measureTime(breaker::breakIntegerRecursiveWithCache, 18));
        assertEquals(729, measureTime(breaker::breakIntegerRecursiveWithCache, 18));
        assertEquals(972, measureTime(breaker::breakIntegerRecursiveWithCache, 19));
        assertEquals(1458, measureTime(breaker::breakIntegerRecursiveWithCache, 20));

        System.out.println("Dynamic programming");

        assertEquals(54, measureTime(breaker::breakIntegerDynamicProgramming, 11));
        assertEquals(81, measureTime(breaker::breakIntegerDynamicProgramming, 12));
        assertEquals(108, measureTime(breaker::breakIntegerDynamicProgramming, 13));
        assertEquals(162, measureTime(breaker::breakIntegerDynamicProgramming, 14));
        assertEquals(243, measureTime(breaker::breakIntegerDynamicProgramming, 15));
        assertEquals(324, measureTime(breaker::breakIntegerDynamicProgramming, 16));
        assertEquals(486, measureTime(breaker::breakIntegerDynamicProgramming, 17));
        assertEquals(729, measureTime(breaker::breakIntegerDynamicProgramming, 18));
        assertEquals(729, measureTime(breaker::breakIntegerDynamicProgramming, 18));
        assertEquals(972, measureTime(breaker::breakIntegerDynamicProgramming, 19));
        assertEquals(1458, measureTime(breaker::breakIntegerDynamicProgramming, 20));

    }

    private int measureTime(IntFunction<Integer> function, int argument) {
        Instant start = Instant.now();
        int result = function.apply(argument);
        Instant finish = Instant.now();
        String msg = MessageFormat.format("{0}  {1}", argument, Duration.between(start, finish).toMillis());
        System.out.println(msg);
        return result;
    }
}
