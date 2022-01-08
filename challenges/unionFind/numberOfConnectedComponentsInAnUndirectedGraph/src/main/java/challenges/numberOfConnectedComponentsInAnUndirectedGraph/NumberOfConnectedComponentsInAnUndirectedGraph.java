package challenges.numberOfConnectedComponentsInAnUndirectedGraph;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

    private int[] parents;
    private int[] ranks;

    public int unionFind(int n, int[][] edges) {
        parents = new int[n];
        ranks = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        int result = n;
        for (int[] edge : edges) {
            result -= union(edge[0], edge[1]);
        }
        return result;
    }

    // Tells which group the element belongs to
    private int find(int node) {
        int result = node;

        while(result != parents[result]) {
            parents[result] = parents[parents[result]];
            result = parents[result];
        }

        return result;
    }

    // Merges two groups
    private int union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);

        if(parent1 == parent2) {
            return 0;
        }

        if(ranks[parent2] > ranks[parent1]) {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        } else {
            parents[parent2] = parent1;
            ranks[parent1] += ranks[parent2];
        }
        return 1;
    }
}

// TODO number of provinces
