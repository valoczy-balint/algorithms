package sort.heap;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HeapSortTest {

    @Test
    public void test() {
        HeapSort sort = new HeapSort();

        List<Integer> expected1 = Arrays.asList(1, 2, 3, 5);
        List<Integer> input1 = Arrays.asList(1, 5, 3, 2);

        List<Integer> expected2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> input2 = Arrays.asList(1, 5, 7, 2, 4, 9, 8, 3, 6);

        List<Integer> result1 = sort.sort(input1);
        List<Integer> result2 = sort.sort(input2);

        Assertions.assertEquals(expected1, result1);
        Assertions.assertEquals(expected2, result2);
    }
}
