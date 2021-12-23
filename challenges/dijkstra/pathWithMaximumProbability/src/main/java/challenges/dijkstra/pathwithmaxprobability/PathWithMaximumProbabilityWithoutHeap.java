package challenges.dijkstra.pathwithmaxprobability;

import java.util.*;

public class PathWithMaximumProbabilityWithoutHeap {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Double> mostProbablePaths = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        mostProbablePaths.put(start, 1.0);

        while (visited.size() < n) {
            Pair<Integer, Double> mostProbableUnvisited = findMostProbableUnvisited(mostProbablePaths, visited);
            int currentNode = mostProbableUnvisited.key;
            double currentProbability = mostProbableUnvisited.value;

            Map<Integer, Double> neighbours = collectNeighbours(currentNode, edges, succProb);

            for (Map.Entry<Integer, Double> neighbour : neighbours.entrySet()) {
                Integer neighbourNode = neighbour.getKey();
                double neighbourPossibility = currentProbability * neighbour.getValue();

                if (!visited.contains(neighbourNode)) {
                    if (!mostProbablePaths.containsKey(neighbourNode)) {
                        mostProbablePaths.put(neighbourNode, neighbourPossibility);
                    } else if (mostProbablePaths.get(neighbourNode) < neighbourPossibility) {
                        mostProbablePaths.put(neighbourNode, neighbourPossibility);
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

    private Pair<Integer, Double> findMostProbableUnvisited(Map<Integer, Double> map, Set<Integer> visited) {
        Pair<Integer, Double> result = new Pair<>(0, 0.0);
        for (Integer key : map.keySet()) {
            if(map.get(key) > result.value && !visited.contains(key)) {
                result = new Pair<>(key, map.get(key));
            }
        }
        return result;
    }

    private Map<Integer, Double> collectNeighbours(int currentNode, int[][] edges, double[] succProb) {
        Map<Integer, Double> result = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == currentNode) {
                result.put(edges[i][1], succProb[i]);
            } else if (edges[i][1] == currentNode) {
                result.put(edges[i][0], succProb[i]);
            }
        }
        return result;
    }
}
