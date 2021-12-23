package challenges.dijkstra.pathwithmaxprobability;

// This is ridiculous, everybody should just use kotlin at this point
// Reason of existence: leetcode doesn't accept AbstractMap entry
public class Pair<S, R> {
    public S key;
    public R value;

    public Pair(S key, R value) {
        this.key = key;
        this.value = value;
    }
}
