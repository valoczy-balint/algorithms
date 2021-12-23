package challenges.dijkstra.pathwithmaxprobability;

import org.jetbrains.annotations.NotNull;

public class PossibleRoute implements Comparable<PossibleRoute> {
    public double probability;
    public int node;

    public PossibleRoute(double probability, int node) {
        this.probability = probability;
        this.node = node;
    }

    @Override
    public int compareTo(@NotNull PossibleRoute possibleRoute) {
        double result = this.probability - possibleRoute.probability;
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
