package challenges.bfs.shortestReach;

import java.util.*;

// https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
public class ShortestReach {

    public int[] shortestReach(int[][] edges, int s, int n) {
        Map<Integer, List<Integer>> graph = createGraph(edges);

        // node, hop count
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(s, 0));

        Map<Integer, Integer> nodeToDistance = new HashMap<>();

        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> current = queue.remove();
            Integer currentNode = current.getKey();
            Integer currentDistance = current.getValue();

            if (!nodeToDistance.containsKey(currentNode)) {
                queue.addAll(
                        graph.get(currentNode).stream().map(neighbourNode ->
                                new AbstractMap.SimpleEntry<>(neighbourNode, currentDistance + 1)
                        ).toList());

                nodeToDistance.put(currentNode, currentDistance);
            }
        }

        int[] result = new int[n - 1];
        for (int i = 2; i <= n; i++) {
            result[i - 2] = nodeToDistance.getOrDefault(i, -1);
        }
        return result;
    }

    private Map<Integer, List<Integer>> createGraph(int[][] edges) {
        Map<Integer, List<Integer>> result = new HashMap<>();

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            if (!result.containsKey(node1)) {
                List<Integer> neighbours = new ArrayList<>();
                neighbours.add(node2);
                result.put(node1, neighbours);

                if (!result.containsKey(node2)) {
                    neighbours = new ArrayList<>();
                    neighbours.add(node1);
                    result.put(node2, neighbours);
                } else {
                    result.get(node2).add(node1);
                }
            } else {
                result.get(node1).add(node2);

                if (!result.containsKey(node2)) {
                    List<Integer> neighbours = new ArrayList<>();
                    neighbours.add(node1);
                    result.put(node2, neighbours);
                } else {
                    result.get(node2).add(node1);
                }
            }
        }

        return result;
    }
}
