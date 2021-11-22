package dp.integerBreak;

import java.util.HashMap;
import java.util.Map;

public class Breaker {

    public int breakIntegerRecursive(int number) {
        if (number == 1) {
            return 1;
        }

        int result = number;
        for (int i = 1; i < number; i++) {
            int maxProduct1 = breakIntegerRecursive(i);
            int maxProduct2 = breakIntegerRecursive(number - i);

            if (maxProduct1 * maxProduct2 > result) {
                result = maxProduct1 * maxProduct2;
            }
        }

        return result;
    }

    public int breakIntegerRecursiveWithCache(int number) {
        return recursiveWithCache(number, new HashMap<>());
    }

    private int recursiveWithCache(int number, Map<Integer, Integer> cache) {
        if (cache.containsKey(number)) {
            return cache.get(number);
        }
        if (number == 1) {
            return 1;
        }

        int result = number;
        for (int i = 1; i < number; i++) {
            int maxProduct1 = recursiveWithCache(i, cache);
            int maxProduct2 = recursiveWithCache(number - i, cache);

            if (maxProduct1 * maxProduct2 > result) {
                result = maxProduct1 * maxProduct2;
            }
        }
        cache.put(number, result);
        return result;
    }

    public int breakIntegerDynamicProgramming(int number) {

        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 1; i < number+1; i++) {
            int result = i;

            for (int j = 1; j < i; j++) {
                int maxProduct1 = cache.get(j);
                int maxProduct2 = cache.get(i - j);

                if (result < maxProduct1 * maxProduct2) {
                    result = maxProduct1 * maxProduct2;
                }
            }
            cache.put(i, result);
        }

        return cache.get(number);
    }
}
