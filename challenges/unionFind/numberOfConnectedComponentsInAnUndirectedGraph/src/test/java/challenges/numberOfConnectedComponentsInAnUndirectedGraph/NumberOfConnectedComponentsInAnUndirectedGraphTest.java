package challenges.numberOfConnectedComponentsInAnUndirectedGraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfConnectedComponentsInAnUndirectedGraphTest {
    private final NumberOfConnectedComponentsInAnUndirectedGraph sut
            = new NumberOfConnectedComponentsInAnUndirectedGraph();


    @Test
    public void test() {
        int n = 5;
        int[][] edges = new int[][]{{0,1}, {1,2}, {3,4}};

        int result = sut.unionFind(n, edges);
        assertEquals(2, result);
    }
}
