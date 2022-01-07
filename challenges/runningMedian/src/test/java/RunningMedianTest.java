import challenges.runningMedian.RunningMedian;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RunningMedianTest {
    @Test
    public void test() {
        List<Integer> input = List.of(12, 4, 5, 3, 8, 7);
        List<Double> result = RunningMedian.runningMedian(input);
        List<Double> expected = List.of(12.0, 8.0, 5.0, 4.5, 5.0, 6.0);

        Assertions.assertEquals(expected, result);
    }
}
