import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SelectSortTest {

    @Test
    public void test() {

        SelectSort sort = new SelectSort();

        List<Integer> input1 = Arrays.asList(1, 5, 3, 2);

        List<Integer> input2 = Arrays.asList(1, 5, 7, 2, 4, 9, 8, 3, 6);

        System.out.println(sort.sort(input1));
        System.out.println(sort.sort(input2));
    }
}
