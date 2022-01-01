package challenges.bfs.shortestReach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestReachTest {
    private final ShortestReach shortestReach = new ShortestReach();

    @Test
    public void test() {
        int n = 6;
        int s = 1;
        Integer[][] edges = new Integer[][]{{1,2},{2,3},{3,4},{1,5}};
        List<String> expected = List.of("6 12 18 6 -1 ");
        List<String> result = shortestReach.shortestReach(List.of(new Input(n, s, edges)));

        assertEquals(expected, result);
    }
}
