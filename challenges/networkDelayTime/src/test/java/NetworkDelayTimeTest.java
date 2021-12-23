import org.junit.jupiter.api.Assertions;

public class NetworkDelayTimeTest {

    @org.junit.jupiter.api.Test
    public void test() {
        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;

        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int result = networkDelayTime.networkDelayTime(times, n, k);

        Assertions.assertEquals(2, result);
    }

    @org.junit.jupiter.api.Test
    public void test2() {
        int[][] times = new int[][]{{1, 2, 1}};
        int n = 2;
        int k = 1;

        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int result = networkDelayTime.networkDelayTime(times, n, k);

        Assertions.assertEquals(1, result);
    }

    @org.junit.jupiter.api.Test
    public void test3() {
        int[][] times = new int[][]{{1, 2, 1}};
        int n = 2;
        int k = 2;

        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int result = networkDelayTime.networkDelayTime(times, n, k);

        Assertions.assertEquals(-1, result);
    }
}
