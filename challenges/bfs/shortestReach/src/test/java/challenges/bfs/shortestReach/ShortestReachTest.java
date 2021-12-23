package challenges.bfs.shortestReach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShortestReachTest {
    private ShortestReach shortestReach = new ShortestReach();

    @Test
    public void test() {
        int n = 6;
        int s = 1;
        int[][] edges = new int[][]{{1,2},{2,3},{3,4},{1,5}};

        int[] expected = new int[]{1,2,3,1,-1};
        int[] result = shortestReach.shortestReach(edges, s, n);

        assertArrayEquals(expected, result);
    }
}
