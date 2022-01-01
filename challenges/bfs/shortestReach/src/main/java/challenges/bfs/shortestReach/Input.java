package challenges.bfs.shortestReach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Input {
    public int n;
    public int s;
    public Map<Integer, List<Integer>> edges;

    public Input(int n, int s, Integer[][] edges) {
        this.n = n;
        this.s = s;
        this.edges = new HashMap<>();
        for (Integer[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            if (!this.edges.containsKey(node1)) {
                List<Integer> neighbours = new ArrayList<>();
                neighbours.add(node2);
                this.edges.put(node1, neighbours);

                if (!this.edges.containsKey(node2)) {
                    neighbours = new ArrayList<>();
                    neighbours.add(node1);
                    this.edges.put(node2, neighbours);
                } else {
                    this.edges.get(node2).add(node1);
                }
            } else {
                this.edges.get(node1).add(node2);

                if (!this.edges.containsKey(node2)) {
                    List<Integer> neighbours = new ArrayList<>();
                    neighbours.add(node1);
                    this.edges.put(node2, neighbours);
                } else {
                    this.edges.get(node2).add(node1);
                }
            }
        }
    }

    public String toString() {
        return s + " " + n + " " + edges;
    }
}
