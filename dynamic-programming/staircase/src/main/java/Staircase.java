import java.util.Arrays;

public class Staircase {

    public int calculate(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);

        int result = recursive(n, cache);
        System.out.println("Cache: " + Arrays.toString(cache));

        return result;
    }

    private int recursive(int n, int[] cache) {
        if (n < 0) {
            return 0;
        } else if (cache[n] == -1) {
            if (n == 0) {
                cache[n] = 1;
            } else {
                cache[n] = recursive(n - 1, cache) + recursive(n - 2, cache);
            }
        }

        return cache[n];
    }
}
