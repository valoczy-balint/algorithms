package challenges.swapNode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapNodesTest {
    private final SwapNodes swapNodes = new SwapNodes();

    @Test
    public void test() {
        List<List<Integer>> input = List.of(
                new ArrayList<>(List.of(2, 3)),
                new ArrayList<>(List.of(-1, 4)),
                new ArrayList<>(List.of(-1, 5)),
                new ArrayList<>(List.of(-1, -1)),
                new ArrayList<>(List.of(-1, -1))
        );
        List<Integer> queries = new ArrayList<>(List.of(2));
        List<List<Integer>> expected =
                new ArrayList<>(List.of((new ArrayList<>(Arrays.asList(4, 2, 1, 5, 3)))));

        List<List<Integer>> result = swapNodes.swapNodes(input, queries);

        assertEquals(expected, result);
    }
}
