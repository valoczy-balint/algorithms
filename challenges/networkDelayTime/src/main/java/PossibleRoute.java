import org.jetbrains.annotations.NotNull;

public class PossibleRoute implements Comparable<PossibleRoute> {
    public int distance;
    public int node;

    public PossibleRoute(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }

    @Override
    public int compareTo(@NotNull PossibleRoute possibleRoute) {
        return this.distance - possibleRoute.distance;
    }
}
