import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlidingWindowMaximumTest {

    private final SlidingWindowMaximum sut = new SlidingWindowMaximum();

    @org.junit.jupiter.api.Test
    public void test() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        assertEquals(new int[]{3, 3, 5, 5, 6, 7}, sut.maxSlidingWindow(nums, k));
    }
}
