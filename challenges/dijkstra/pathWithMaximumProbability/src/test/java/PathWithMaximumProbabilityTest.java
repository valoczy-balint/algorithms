import challenges.dijkstra.pathwithmaxprobability.PathWithMaximumProbabilityWithHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PathWithMaximumProbabilityTest {
    private final PathWithMaximumProbabilityWithHeap pathWithMaximumProbabilityWithHeap = new PathWithMaximumProbabilityWithHeap();

    @Test
    public void test() {
        int n = 3;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = new double[]{0.5, 0.5, 0.2};
        int start = 0;
        int end = 2;

        double expected = 0.25;
        double result = pathWithMaximumProbabilityWithHeap.maxProbability(n, edges, succProb, start, end);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test2() {
        int n = 3;
        int[][] edges = new int[][]{{0, 1}};
        double[] succProb = new double[]{0.5};
        int start = 0;
        int end = 2;

        double expected = 0;
        double result = pathWithMaximumProbabilityWithHeap.maxProbability(n, edges, succProb, start, end);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test3() {
        int n = 500;
        int[][] edges = new int[][]{{193,229},{133,212},{224,465}};
        double[] succProb = new double[]{0.91,0.78,0.64};
        int start = 4;
        int end = 364;

        double expected = 0;
        double result = pathWithMaximumProbabilityWithHeap.maxProbability(n, edges, succProb, start, end);

        Assertions.assertEquals(expected, result);
    }
}
