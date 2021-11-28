import org.junit.jupiter.api.Test;
import sort.quick.QuickSort;

import java.util.Arrays;
import java.util.List;

public class QuickSortTest {

    @Test
    public void test() {

        QuickSort quickSort = new QuickSort();

        List<Integer> input1 = Arrays.asList(1, 5, 3, 2);

        List<Integer> input2 = Arrays.asList(1, 5, 7, 2, 4, 9, 8, 3, 6);

        System.out.println(quickSort.sort(input1));

    }
}
