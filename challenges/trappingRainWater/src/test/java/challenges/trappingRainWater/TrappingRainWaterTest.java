package challenges.trappingRainWater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrappingRainWaterTest {

    private TrappingRainWater trappingRainWater = new TrappingRainWater();

    @Test
    public void test() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trappingRainWater.trap(height);

        assertEquals(6, result);
    }
}
