package challenges.candies;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CandiesTest {
    Candies candies = new Candies();
    @Test
    public void test() {
        List<Integer> input = new ArrayList<>(100001);
        input.add(100000);
        for (int i = 100000; i > 0; i--) {
            input.add(i);
        }

        long result = this.candies.candies(input);

        System.out.println(result);

    }
}
