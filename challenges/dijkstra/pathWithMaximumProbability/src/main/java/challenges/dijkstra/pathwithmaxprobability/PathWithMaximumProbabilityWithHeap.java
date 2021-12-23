package challenges.dijkstra.pathwithmaxprobability;

import java.util.*;

import static java.util.Collections.reverseOrder;

public class PathWithMaximumProbabilityWithHeap {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> graph = buildMap(edges, succProb);
        Map<Integer, Double> mostProbablePaths = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<PossibleRoute> possibleRoutes = new PriorityQueue<>(reverseOrder());
        possibleRoutes.add(new PossibleRoute(1.0, start));

        while (visited.size() < n && !possibleRoutes.isEmpty()) {
            PossibleRoute possibleRoute = possibleRoutes.remove();
            int currentNode = possibleRoute.node;
            double currentProbability = possibleRoute.probability;

            Map<Integer, Double> neighbours = graph.get(currentNode);

            if (neighbours != null) {
                for (Map.Entry<Integer, Double> neighbour : neighbours.entrySet()) {
                    Integer neighbourNode = neighbour.getKey();
                    double neighbourProbability = currentProbability * neighbour.getValue();

                    if (!visited.contains(neighbourNode)) {
                        if (!mostProbablePaths.containsKey(neighbourNode)) {
                            mostProbablePaths.put(neighbourNode, neighbourProbability);
                        } else if (mostProbablePaths.get(neighbourNode) < neighbourProbability) {
                            mostProbablePaths.put(neighbourNode, neighbourProbability);
                        }
                        possibleRoutes.add(new PossibleRoute(neighbourProbability, neighbourNode));
                    }
                }
            }
            visited.add(currentNode);
        }

        if (mostProbablePaths.containsKey(end)) {
            return mostProbablePaths.get(end);
        } else {
            return 0;
        }
    }

    private Map<Integer, Map<Integer, Double>> buildMap(int[][] edges, double[] succProb) {
        Map<Integer, Map<Integer, Double>> result = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            double weight = succProb[i];

            if (result.containsKey(node1)) {
                result.get(node1).put(node2, weight);

                if (result.containsKey(node2)) {
                    result.get(node2).put(node1, weight);
                } else {
                    HashMap<Integer, Double> map = new HashMap<>();
                    map.put(node1, weight);
                    result.put(node2, map);
                }
            } else {
                HashMap<Integer, Double> map = new HashMap<>();
                map.put(node2, weight);
                result.put(node1, map);
                if (result.containsKey(node2)) {
                    result.get(node2).put(node1, weight);
                } else {
                    HashMap<Integer, Double> map2 = new HashMap<>();
                    map2.put(node1, weight);
                    result.put(node2, map2);
                }
            }
        }
        return result;
    }
}
