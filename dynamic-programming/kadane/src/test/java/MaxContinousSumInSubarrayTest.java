import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxContinousSumInSubarrayTest {
    private final MaxContinousSumInSubarray maxContinousSumInSubarray = new MaxContinousSumInSubarray();

    @Test
    public void kadaneTest() {
        int[] input = new int[]{-2,2,5,-11,6};

        int result = maxContinousSumInSubarray.kadane(input);
        assertEquals(7, result);
    }
}
